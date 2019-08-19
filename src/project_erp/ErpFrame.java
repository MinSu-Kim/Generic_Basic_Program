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
import project_erp.ui.ErpUI;
import project_erp.ui.content.AbstractContent;
import project_erp.ui.content.PanelDepartment;
import project_erp.ui.content.PanelEmployee;
import project_erp.ui.content.PanelTitle;
import project_erp.ui.list.AbstractList;
import project_erp.ui.list.PanelDeptList;
import project_erp.ui.list.PanelEmpList;
import project_erp.ui.list.PanelTitleList;

@SuppressWarnings("serial")
public class ErpFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDept;
	private JButton btnEmp;
	private JButton btnTitle;

	private List<Employee> empList;
	private List<Department> deptList;
	private List<Title> titleList;
	
	private AbstractContent<Title> pt;
	private AbstractContent<Department> pd;
	private AbstractContent<Employee> pe;
	private AbstractList<Title> ptl;
	private AbstractList<Department> pdl;
	private AbstractList<Employee> pel;
	
	private Map<DtoType, ErpUI<?>> map = new HashMap<>();
	
	private static final String[] TITLES = {"직책 관리", "부서 관리", "사원 관리"};
	public ErpFrame() {
		initComponents();
		
	}

	public void setDataFileMgn(DataFileMgn dfm) {
		this.titleList = dfm.getTitleList();
		this.deptList = dfm.getDeptList();
		this.empList = dfm.getEmpList();
		
		pt = new PanelTitle();
		pd = new PanelDepartment();
		pe = new PanelEmployee();
		
		ptl = new PanelTitleList();
		pdl = new PanelDeptList();
		pel = new PanelEmpList();
		
		ptl.setItemList(titleList);
		pdl.setItemList(deptList);
		pel.setItemList(empList);
		
		((PanelEmployee)pe).setTitleList(titleList);
		((PanelEmployee)pe).setDeptList(deptList);
		
		map.put(DtoType.DEPARTMENT, new ErpUI<>(TITLES[1], pd, pdl, deptList));
		map.put(DtoType.EMPLOYEE, new ErpUI<>(TITLES[2], pe, pel, empList));
		map.put(DtoType.TITLE, new ErpUI<>(TITLES[0], pt, ptl, titleList));
	}

	private void initComponents() {
		setTitle("ERP 관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 96);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		btnEmp = new JButton("사원 관리");
		btnEmp.addActionListener(this);
		contentPane.add(btnEmp);

		btnDept = new JButton("부서 관리");
		btnDept.addActionListener(this);
		contentPane.add(btnDept);

		btnTitle = new JButton("직책 관리");
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
