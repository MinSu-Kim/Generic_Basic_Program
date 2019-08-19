package project_erp.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import project_erp.dto.Department;
import project_erp.dto.Title;
import project_erp.ui.content.AbstractContent;
import project_erp.ui.list.AbstractList;

@SuppressWarnings("serial")
public class ErpUI<T> extends JFrame implements ActionListener {

	private JPanel contentPane;

	private AbstractList<T> pContentList;
	private AbstractContent<T> pContent;
	private List<T> itemList;
	private List<Department> deptList;
	private List<Title> titleList;
	
	private JButton btnAdd;
	private JButton btnCancel;

	private JMenuItem mntmUpdate;
	private JMenuItem mntmDelete;
	
	private DtoType type;
	
	public ErpUI(DtoType type, String title, List<T> itemList, List<Department> deptList, List<Title> titleLIList) {
		this.type = type;
		this.itemList = itemList;
		this.deptList = deptList;
		this.titleList = titleLIList;
		
		setTitle(title);
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BoxLayout(pNorth, BoxLayout.Y_AXIS));

		pContent = PanelFactory.<T>createContent(type, itemList, deptList, titleList);
		pNorth.add(pContent);
		
		JPanel pbtns = new JPanel();
		pNorth.add(pbtns);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pbtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pbtns.add(btnCancel);

		pContentList = PanelFactory.<T>createList(type, itemList);
		pContentList.setPopUpMenu(createPopUpMenu());
		
		contentPane.add(pContentList, BorderLayout.CENTER);
	}
	
	private JPopupMenu createPopUpMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);

		mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);
		return popupMenu;
	}
	
	public void loadData() {
		pContentList.loadData();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnCancel) {
				actionPerformedBtnCancel(e);
			}
			if (e.getSource() == btnAdd) {
				if (e.getActionCommand().equals("추가")) {
					actionPerformedBtnAdd(e);
				} else {
					actionPerformedBtnUpdate(e);
				}
			}
			if (e.getSource() == mntmUpdate) {
				actionPerformedMntmTitleUpdate(e);
			}
			if (e.getSource() == mntmDelete) {
				actionPerformedMntmTitleDelete(e);
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	private void actionPerformedBtnUpdate(ActionEvent e) {
		T item =  pContent.getItem();
		itemList.set(itemList.indexOf(item), item);
		loadData();
		btnAdd.setText("추가");
		pContent.clearComponent();
		JOptionPane.showMessageDialog(null, "수정 완료");
	}

	private void actionPerformedMntmTitleDelete(ActionEvent e) throws Exception {
		pContentList.deleteSelectedItem();
		loadData();
		JOptionPane.showMessageDialog(null, "삭제 완료");
	}

	private void actionPerformedMntmTitleUpdate(ActionEvent e) throws Exception {
		btnAdd.setText("수정");
		pContent.setItem(pContentList.getSelectedItem());
	}

	protected void actionPerformedBtnAdd(ActionEvent e) throws Exception {
		T item = pContent.getItem();
		JOptionPane.showMessageDialog(null, item);
		
		if (itemList.contains(item)) {
			throw new Exception("중복");
		}
		
		itemList.add(item);
		pContent.clearComponent();
		loadData();
		JOptionPane.showMessageDialog(null, "추가 완료");
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.clearComponent();
	}
	
}
