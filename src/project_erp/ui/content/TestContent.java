package project_erp.ui.content;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project_erp.dto.Department;
import project_erp.dto.Employee;
import project_erp.dto.Title;

@SuppressWarnings("serial")
public class TestContent extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnAdd;
	private AbstractContent<Title> pTitleContent;
	private AbstractContent<Department> pDeptContent;
	private AbstractContent<Employee> pEmpContent;
	private JButton btnTitle;
	private JButton btnDepartment;
	private JButton btnEmployee;
	private List<Department> deptList;
	private List<Title> titleList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestContent frame = new TestContent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestContent() {
		initComponents();
		createList();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("확인");
		btnAdd.addActionListener(this);

		btnTitle = new JButton("직책");
		btnTitle.addActionListener(this);
		pBtns.add(btnTitle);

		btnDepartment = new JButton("부서");
		btnDepartment.addActionListener(this);
		pBtns.add(btnDepartment);

		btnEmployee = new JButton("사원");
		btnEmployee.addActionListener(this);
		pBtns.add(btnEmployee);
		pBtns.add(btnAdd);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnDepartment) {
				actionPerformedBtnDepartment(e);
			}
			if (e.getSource() == btnTitle) {
				actionPerformedBtnTitle(e);
			}
			if (e.getSource() == btnEmployee) {
				actionPerformedBtnEmployee(e);
			}
	
			if (e.getSource() == btnAdd) {
				actionPerformedBtnAdd(e);
			}
			if (e.getSource() == btnCancel) {
				actionPerformedBtnCancel(e);
			}
			if (e.getSource() == btnUpdate) {
				actionPerformedBtnUpdate(e);
			}
		}catch(ArrayIndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "비어있는 패널 패널을 추가하세요");
		}
	}

	protected void actionPerformedBtnUpdate(ActionEvent e) {
		System.out.println(" contentPane.getComponent(1) " + contentPane.getComponent(1));

		if (pTitleContent == contentPane.getComponent(1)) {
			Title title = new Title(1, "사장");
			pTitleContent.setItem(title);
			return;
		}
		if (pDeptContent == contentPane.getComponent(1)) {
			Department dept = new Department(1, "개발", 9);
			pDeptContent.setItem(dept);
			return;
		}
		if (pEmpContent == contentPane.getComponent(1)) {
			Employee emp = new Employee(1, "나사장", new Department(1, "개발", 9), new Title(1, "사장"), true,
					Arrays.asList("축구", "족구"), new Date(), "1234", 5000000);
			pEmpContent.setItem(emp);
			return;
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		
		AbstractContent<?> content = ((AbstractContent<?>)contentPane.getComponent(1));
		JTextField tfNo = content.getTfNo();
		JOptionPane.showMessageDialog(null, tfNo.getText().trim());
		content.clearComponent();
		
/*		
		if (pTitleContent == contentPane.getComponent(1)) {
			JTextField tfNo = pTitleContent.getTfNo();
			JOptionPane.showMessageDialog(null, tfNo.getText().trim());
			pTitleContent.clearComponent();
		}
		if (pDeptContent == contentPane.getComponent(1)) {
			JTextField tfNo = pDeptContent.getTfNo();
			JOptionPane.showMessageDialog(null, tfNo.getText().trim());
			pDeptContent.clearComponent();
		}
		if (pEmpContent == contentPane.getComponent(1)) {
			JTextField tfNo = pEmpContent.getTfNo();
			JOptionPane.showMessageDialog(null, tfNo.getText().trim());
			pEmpContent.clearComponent();
		}
*/
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		AbstractContent<?> content = ((AbstractContent<?>)contentPane.getComponent(1));
		JOptionPane.showMessageDialog(null, content.getItem());

/*
		if (pTitleContent == contentPane.getComponent(1)) {
			Title newTitle = pTitleContent.getItem();
			JOptionPane.showMessageDialog(null, newTitle);
		}
		if (pDeptContent == contentPane.getComponent(1)) {
			Department dept = pDeptContent.getItem();
			JOptionPane.showMessageDialog(null, dept);
		}
		if (pEmpContent == contentPane.getComponent(1)) {
			Employee emp = pEmpContent.getItem();
			JOptionPane.showMessageDialog(null, emp);
		}
*/
	}

	protected void actionPerformedBtnEmployee(ActionEvent e) {
		clearComponent();
		pEmpContent = new PanelEmployee();
		((PanelEmployee) pEmpContent).setDeptList(deptList);
		((PanelEmployee) pEmpContent).setTitleList(titleList);
		contentPane.add(pEmpContent, BorderLayout.CENTER);
		reviewUI();
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
	}

	protected void actionPerformedBtnTitle(ActionEvent e) {
		clearComponent();
		pTitleContent = new PanelTitle();
		contentPane.add(pTitleContent, BorderLayout.CENTER);
		reviewUI();
	}

	protected void actionPerformedBtnDepartment(ActionEvent e) {
		clearComponent();
		pDeptContent = new PanelDepartment();
		contentPane.add(pDeptContent, BorderLayout.CENTER);
		reviewUI();
	}

	private void reviewUI() {
		repaint();
		revalidate();
	}

	private void clearComponent() {
		for (Component c : contentPane.getComponents()) {
			if (c instanceof AbstractContent<?>) {
				contentPane.remove(c);
			}
		}
	}
}
