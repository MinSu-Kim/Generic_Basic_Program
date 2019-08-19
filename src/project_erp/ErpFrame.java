package project_erp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_erp.dto.Department;
import project_erp.dto.Employee;
import project_erp.dto.Title;
import project_erp.ui.DtoType;
import project_erp.ui.ErpUI;

@SuppressWarnings("serial")
public class ErpFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDept;
	private JButton btnEmp;
	private JButton btnTitle;

	private List<Employee> empList;
	private List<Department> deptList;
	private List<Title> titleList;
	
	private Map<DtoType, ErpUI<?>> map = new HashMap<>();
	
	public ErpFrame() {
		initComponents();
	}

	public void setDataFileMgn(DataFileMgn dfm) {
		this.titleList = dfm.getTitleList();
		this.deptList = dfm.getDeptList();
		this.empList = dfm.getEmpList();
		
		map.put(DtoType.DEPARTMENT, new ErpUI<>(DtoType.DEPARTMENT, DtoType.DEPARTMENT.getName(), deptList, null, null));
		map.put(DtoType.EMPLOYEE, 	new ErpUI<>(DtoType.EMPLOYEE,	DtoType.EMPLOYEE.getName(), empList, deptList, titleList));
		map.put(DtoType.TITLE, 		new ErpUI<>(DtoType.TITLE,		DtoType.TITLE.getName(), titleList, null, null));
	}

	private void initComponents() {
		setTitle("ERP 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 96);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		btnEmp = new JButton(DtoType.EMPLOYEE.getName());
		btnEmp.addActionListener(this);
		contentPane.add(btnEmp);

		btnDept = new JButton(DtoType.DEPARTMENT.getName());
		btnDept.addActionListener(this);
		contentPane.add(btnDept);

		btnTitle = new JButton(DtoType.TITLE.getName());
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitle) {
			actionPerformedBtnTitle(e);
		}
		if (e.getSource() == btnEmp) {
			actionPerformedBtnEmp(e);
		}
		if (e.getSource() == btnDept) {
			actionPerformedBtnDept(e);
		}
	}
	
	protected void actionPerformedBtnDept(ActionEvent e) {
		map.get(DtoType.DEPARTMENT).loadData();
		map.get(DtoType.DEPARTMENT).setVisible(true);
	}

	protected void actionPerformedBtnEmp(ActionEvent e) {
		map.get(DtoType.EMPLOYEE).loadData();
		map.get(DtoType.EMPLOYEE).setVisible(true);
	}

	protected void actionPerformedBtnTitle(ActionEvent e) {
		map.get(DtoType.TITLE).loadData();
		map.get(DtoType.TITLE).setVisible(true);
	}
}
