package project_erp.ui.list;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import project_erp.dto.Department;
import project_erp.dto.Employee;
import project_erp.dto.Title;

@SuppressWarnings("serial")
public class TestList extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmDeptUpdate;
	private JMenuItem mntmDeptDelete;

	private JMenuItem mntmTitleUpdate;
	private JMenuItem mntmTitleDelete;

	private JMenuItem mntmEmpUpdate;
	private JMenuItem mntmEmpDelete;

	private JButton btnDeptAdd;

	private JPanel pBtns;
	private JButton btnTitleAdd;

	private AbstractList<Title> pTitle;
	private AbstractList<Department> pDept;
	private AbstractList<Employee> pEmp;

	private List<Department> deptList;
	private List<Title> titleList;
	private List<Employee> empList;
	
	private JPanel pList;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnEmpAdd;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestList frame = new TestList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestList() {
		createList();
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnDeptAdd = new JButton("부서 추가하기");
		pBtns.add(btnDeptAdd);

		btnTitleAdd = new JButton("직책 추가하기");
		btnTitleAdd.addActionListener(this);
		pBtns.add(btnTitleAdd);

		btnEmpAdd = new JButton("사원 추가하기");
		btnEmpAdd.addActionListener(this);
		pBtns.add(btnEmpAdd);
		btnDeptAdd.addActionListener(this);

		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new GridLayout(2, 0, 0, 0));

		panel_1 = new JPanel();
		pList.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		pDept = new PanelDeptList();
		panel_1.add(pDept);
		pDept.setItemList(deptList);
		pDept.loadData();

		pDept.setPopUpMenu(createDeptPopUpMenu());

		pTitle = new PanelTitleList();
		panel_1.add(pTitle);
		pTitle.setItemList(titleList);
		pTitle.loadData();
		pTitle.setPopUpMenu(createTitlePopUpMenu());

		panel_2 = new JPanel();
		pList.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		pEmp = new PanelEmpList();
		panel_2.add(pEmp);
		pEmp.setItemList(empList);
		pEmp.loadData();
		pEmp.setPopUpMenu(createEmpPopUpMenu());
	}

	private JPopupMenu createEmpPopUpMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		mntmEmpUpdate = new JMenuItem("수정");
		mntmEmpUpdate.addActionListener(this);
		popupMenu.add(mntmEmpUpdate);

		mntmEmpDelete = new JMenuItem("삭제");
		mntmEmpDelete.addActionListener(this);
		popupMenu.add(mntmEmpDelete);
		return popupMenu;
	}

	private JPopupMenu createTitlePopUpMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		mntmTitleUpdate = new JMenuItem("수정");
		mntmTitleUpdate.addActionListener(this);
		popupMenu.add(mntmTitleUpdate);

		mntmTitleDelete = new JMenuItem("삭제");
		mntmTitleDelete.addActionListener(this);
		popupMenu.add(mntmTitleDelete);
		return popupMenu;
	}

	private JPopupMenu createDeptPopUpMenu() {
		JPopupMenu popupMenu = new JPopupMenu();
		mntmDeptUpdate = new JMenuItem("수정");
		mntmDeptUpdate.addActionListener(this);
		popupMenu.add(mntmDeptUpdate);

		mntmDeptDelete = new JMenuItem("삭제");
		mntmDeptDelete.addActionListener(this);
		popupMenu.add(mntmDeptDelete);
		return popupMenu;
	}

	private void createList() {
		deptList = new ArrayList<Department>();
		deptList.add(new Department(1, "개발", 3));
		deptList.add(new Department(2, "총무", 13));
		deptList.add(new Department(3, "인사", 30));
		deptList.add(new Department(4, "마케팅", 23));

		titleList = new ArrayList<Title>();
		titleList.add(new Title(1, "사장"));
		titleList.add(new Title(2, "부장"));
		titleList.add(new Title(3, "과장"));
		titleList.add(new Title(4, "대리"));

		empList = new ArrayList<>();
//		Employee(int empNo, String empName, Department dept, Title title, boolean isMale, List<String> hobbys,
//				Date joinDate, String passwd, int salary)
		empList.add(new Employee(1, "황기태", new Department(2, "총무", 13), new Title(1, "사장"), true,
				Arrays.asList("배구", "야구"), new Date(), "1234", 2000000));
	}

	public void actionPerformed(ActionEvent e) {
		
		try {
			if (e.getSource() == btnTitleAdd) {
				actionPerformedBtnTitleAdd(e);
			}
			if (e.getSource() == btnDeptAdd) {
				actionPerformedBtnAdd(e);
			}
			if (e.getSource() == btnEmpAdd) {
				actionPerformedBtnEmpAdd(e);
			}
			
			if (e.getSource() == mntmDeptDelete) {
				actionPerformedMntmDeptDelete(e);
			}
			if (e.getSource() == mntmDeptUpdate) {
				actionPerformedMntmDeptUpdate(e);
			}

			if (e.getSource() == mntmTitleUpdate) {
				actionPerformedMntmTitleUpdate(e);
			}
			if (e.getSource() == mntmTitleDelete) {
				actionPerformedMntmTitleDelete(e);
			}
			
			if (e.getSource() == mntmEmpUpdate) {
				actionPerformedMntmEmpUpdate(e);
			}
			if (e.getSource() == mntmEmpDelete) {
				actionPerformedMntmEmpDelete(e);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	private void actionPerformedMntmEmpDelete(ActionEvent e) throws Exception {
		pEmp.deleteSelectedItem();
	}

	private void actionPerformedMntmEmpUpdate(ActionEvent e) throws Exception {
		Employee emp = pEmp.getSelectedItem();
		JOptionPane.showMessageDialog(null, "수정할 사원" + emp);
	}

	private void actionPerformedMntmTitleDelete(ActionEvent e) throws Exception {
		pTitle.deleteSelectedItem();
	}

	private void actionPerformedMntmTitleUpdate(ActionEvent e) throws Exception {
		Title updateTitle = pTitle.getSelectedItem();
		JOptionPane.showMessageDialog(null, "수정할 부서" + updateTitle);
	}

	protected void actionPerformedMntmDeptUpdate(ActionEvent e) throws Exception {
		Department updateDept = pDept.getSelectedItem();
		JOptionPane.showMessageDialog(null, "수정할 부서" + updateDept);
	}

	protected void actionPerformedMntmDeptDelete(ActionEvent e) throws Exception {
		pDept.deleteSelectedItem();
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		deptList.add(new Department(10, "기획", 60));
		pDept.loadData();
	}

	protected void actionPerformedBtnTitleAdd(ActionEvent e) {
		titleList.add(new Title(5, "사원"));
		pTitle.loadData();
	}

	protected void actionPerformedBtnEmpAdd(ActionEvent e) {
		Department dept = new Department(4, "마케팅", 23);
		Title title = new Title(4, "대리");
		empList.add(new Employee(2, "김효수", dept, title, false, Arrays.asList("수영", "당구"), new Date(), "1234", 3000000));
		pEmp.loadData();
	}
}
