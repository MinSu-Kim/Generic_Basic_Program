package project_erp.ui.content;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import project_erp.dto.Department;

@SuppressWarnings("serial")
public class PanelDepartment extends AbstractContent<Department> {
	private JTextField tfDeptNo;
	private JTextField tfDeptName;
	private JTextField tfFloor;

	public PanelDepartment() {
		super("부서정보");
	}
	
	@Override
	protected void initComponents(String title) {
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 20, 0));
		
		JLabel lblDeptNo = new JLabel("부서 번호");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptNo);
		
		tfDeptNo = new JTextField();
		add(tfDeptNo);
		tfDeptNo.setColumns(10);
		
		JLabel lblDeptName = new JLabel("부서 명");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptName);
		
		tfDeptName = new JTextField();
		tfDeptName.setColumns(10);
		add(tfDeptName);
		
		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		add(tfFloor);
	}
	
	@Override
	public Department getItem() {
		int deptNo = Integer.parseInt(tfDeptNo.getText().trim());
		String deptName = tfDeptName.getText().trim();
		int floor = Integer.parseInt(tfFloor.getText().trim());
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public void setItem(Department dept) {
		tfDeptNo.setText(dept.getDeptNo()+"");
		tfDeptName.setText(dept.getDeptName());
		tfFloor.setText(dept.getFloor()+"");
	}
	
	@Override
	public void clearComponent() {
		tfDeptNo.setText("");
		tfDeptName.setText("");
		tfFloor.setText("");
	}

	@Override
	public JTextField getTfNo() {
		return tfDeptNo;
	}
	
}
