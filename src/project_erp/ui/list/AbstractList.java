package project_erp.ui.list;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public abstract class AbstractList<T> extends JPanel {
	protected JTable table;
	protected List<T> itemList;
	protected String title;
	
	public AbstractList(String title) {
		this.title = title;
		initComponents(title);
	}
	
	private void initComponents(String title) {
		setBorder(new TitledBorder(null, title + " 목록", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		loadData();
		scrollPane.setViewportView(table);
	}

	public void setItemList(List<T> itemList) {
		this.itemList = itemList;
	}
	
	public void loadData() {
		table.setModel(new MyTableModel(getDatas(),getColumnNames()));
		
		tableWidthAndAlign();
	}

	public abstract void tableWidthAndAlign();
	
	protected void tableCellAlign(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	protected void tableSetWidth(int...widths) {
		//媛곴컖 而щ읆�뿉 �쟻�슜
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<widths.length; i++) {
			tcm.getColumn(i).setPreferredWidth(widths[i]);
		}
	}

	protected abstract String[] getColumnNames();

	protected Object[][] getDatas() {
		if (itemList == null) {
			return new Object[][] {};
		}
		
		Object[][] datas = new Object[itemList.size()][];
		for(int i=0; i<datas.length; i++) {
			T t = itemList.get(i);
			datas[i] = getItemToArray(t);
		}
		return datas;
	}

	protected abstract Object[] getItemToArray(T t);

	protected class MyTableModel extends DefaultTableModel{

		public MyTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

	public void setPopUpMenu(JPopupMenu popupMenu) {
		table.setComponentPopupMenu(popupMenu);
	}

	public void deleteSelectedItem() throws Exception {
		T seletedItem = getSelectedItem();
		itemList.remove(seletedItem);
		loadData();
	}

	public T getSelectedItem() throws Exception {
		int seletedRowIndex = table.getSelectedRow();
		if (seletedRowIndex == -1) {
			throw new Exception("해당 " + title + "를 선택하세요");
		}
		return itemList.get(seletedRowIndex) ;
	}
}






