package project_erp.ui.content;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import project_erp.dto.Department;
import project_erp.dto.Title;

@SuppressWarnings("serial")
public class PanelTitle extends AbstractContent<Title> {
	private JTextField tfTitleNo;
	private JTextField tfTitleName;

	public PanelTitle() {
		super("직책 정보");
	}
	
	@Override
	protected void initComponents(String title) {
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 20, 0));
		
		JLabel lblTitleNo = new JLabel("직책 번호");
		lblTitleNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleNo);
		
		tfTitleNo = new JTextField();
		add(tfTitleNo);
		tfTitleNo.setColumns(10);
		
		JLabel lblTitleName = new JLabel("직책 명");
		lblTitleName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitleName);
		
		tfTitleName = new JTextField();
		tfTitleName.setColumns(10);
		add(tfTitleName);
	}
	
	@Override
	public Title getItem() {
		int titleNo = Integer.parseInt(tfTitleNo.getText().trim());
		String titleName = tfTitleName.getText().trim();
		return new Title(titleNo, titleName);
	}

	@Override
	public void setItem(Title title) {
		tfTitleNo.setText(title.getTitleNo()+"");
		tfTitleName.setText(title.getTitleName());
	}
	
	@Override
	public void clearComponent() {
		tfTitleNo.setText("");
		tfTitleName.setText("");
	}

	@Override
	public JTextField getTfNo() {
		return tfTitleNo;
	}

	@Override
	public void setDeptList(List<Department> deptList) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void setTitleList(List<Title> titleList) {
		throw new UnsupportedOperationException();		
	}
}
