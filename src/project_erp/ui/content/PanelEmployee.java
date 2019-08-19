package project_erp.ui.content;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import project_erp.dto.Department;
import project_erp.dto.Employee;
import project_erp.dto.Title;

@SuppressWarnings("serial")
public class PanelEmployee extends AbstractContent<Employee> {
	private JTextField tfEmpNo;		//사원번호
	private JTextField tfEmpName;   //사원명
	private JComboBox<Department> cmbDept;		//부서
	private JComboBox<Title> cmbTitle;		//직책
	private JPasswordField pfPw1;	//패스워드1
	private JPasswordField pfPw2;	//패스워드2
	private JRadioButton rdbMale;	//남자
	private JRadioButton rdbFeMale;	//여자
	private JCheckBox chckBowling;	//볼링
	private JCheckBox chckBaseBall;	//야구	
	private JCheckBox chckSong;		//노래
	private JLabel lblResult;		//비밀번호 일치여부
	private JSpinner spnSalary;		//급여
	private JDateChooser tfJoinDate;

	public PanelEmployee() {
		super("사원 정보");
	}
	
	@Override
	protected void initComponents(String title) {
		setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 20, 0));
		
		JLabel lblEmpNo = new JLabel("사원 번호");
		lblEmpNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEmpNo);
		
		tfEmpNo = new JTextField();
		add(tfEmpNo);
		tfEmpNo.setColumns(10);
		
		JLabel lblEmpName = new JLabel("성명");
		lblEmpName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEmpName);
		
		tfEmpName = new JTextField();
		tfEmpName.setColumns(10);
		add(tfEmpName);
		
		JLabel lblDept = new JLabel("부서");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDept);
		
		cmbDept = new JComboBox<>();
		add(cmbDept);
		
		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		cmbTitle = new JComboBox<>();
		add(cmbTitle);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblGender);
		
		JPanel pGender = new JPanel();
		add(pGender);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		rdbMale = new JRadioButton("남자");
		rdbMale.setSelected(true);
		buttonGroup.add(rdbMale);
		pGender.add(rdbMale);
		
		rdbFeMale = new JRadioButton("여자");
		buttonGroup.add(rdbFeMale);
		pGender.add(rdbFeMale);
		
		JLabel lblHobby = new JLabel("취미");
		lblHobby.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblHobby);
		
		JPanel pHobby = new JPanel();
		add(pHobby);
		
		chckBowling = new JCheckBox("볼링");
		pHobby.add(chckBowling);
		
		chckBaseBall = new JCheckBox("야구");
		pHobby.add(chckBaseBall);
		
		chckSong = new JCheckBox("노래하기");
		pHobby.add(chckSong);
		
		JLabel lblJoinDate = new JLabel("입사일");
		lblJoinDate.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblJoinDate);
		
		tfJoinDate = new JDateChooser();
		tfJoinDate.setDateFormatString("yyyy-MM-dd");
		tfJoinDate.setDate(new Date());
		add(tfJoinDate);
		
		JLabel lblPw1 = new JLabel("비밀번호");
		lblPw1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPw1);
		
		pfPw1 = new JPasswordField();
		pfPw1.setColumns(10);
		add(pfPw1);
		
		JLabel lblPw2 = new JLabel("비밀번호확인");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPw2);
		
		lblResult = new JLabel("");
		lblResult.setForeground(Color.RED);
		
		pfPw2 = new JPasswordField();
		pfPw2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				msg();
			}
			
			private void msg() {
				String p1 = new String(pfPw1.getPassword());
				String p2 = new String(pfPw2.getPassword());
				if (p1.length()==0 || p2.length() == 0) {
					lblResult.setText("비밀번호를 입력하삼");
					return;
				}
				if (p1.equals(p2)) {
					lblResult.setText("일치");
				}else {
					lblResult.setText("일치하지 않음");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				msg();
			}
		});
		pfPw2.setColumns(10);
		add(pfPw2);
		
		JLabel lblConfirm = new JLabel("비밀번호일치여부");
		lblConfirm.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblConfirm);
		
		add(lblResult);
		
		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSalary);
		
		spnSalary = new JSpinner();
		spnSalary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		add(spnSalary);
	}
	
	public void setDeptList(List<Department> deptList) {
		DefaultComboBoxModel<Department> modelDept = new DefaultComboBoxModel<Department>(new Vector<Department>(deptList));
		cmbDept.setModel(modelDept);
		cmbDept.setSelectedIndex(-1);
	}
	
	public void setTitleList(List<Title> titleList) {
		DefaultComboBoxModel<Title> modelTitle = new DefaultComboBoxModel<Title>(new Vector<Title>(titleList));
		cmbTitle.setModel(modelTitle);
		cmbTitle.setSelectedIndex(-1);
	}
	
	@Override
	public Employee getItem() {
		validCheck();
		int empNo = Integer.parseInt(tfEmpNo.getText().trim());
		String empName = tfEmpName.getText().trim();
		Department dept = (Department) cmbDept.getSelectedItem();
		Title title = (Title) cmbTitle.getSelectedItem();
		boolean isMale = rdbMale.isSelected()?true:false;
		List<String> hobbys = new ArrayList<String>();
		if (chckBaseBall.isSelected()) {
			hobbys.add(chckBaseBall.getText());
		}
		if (chckBowling.isSelected()) {
			hobbys.add(chckBowling.getText());
		}
		if (chckSong.isSelected()) {
			hobbys.add(chckSong.getText());
		}
		Date joinDate = tfJoinDate.getDate();
		String passwd = new String(pfPw1.getPassword());
		int salary = (int) spnSalary.getValue();
		return new Employee(empNo, empName, dept, title, isMale, hobbys, joinDate, passwd, salary);
	}

	@Override
	public void setItem(Employee employee) {
		tfEmpNo.setText(employee.getEmpNo()+"");
		tfEmpName.setText(employee.getEmpName());
		cmbDept.setSelectedItem(employee.getDept());
		cmbTitle.setSelectedItem(employee.getTitle());
		tfJoinDate.setDate(employee.getJoinDate());
		pfPw1.setText(employee.getPasswd());
		pfPw2.setText(employee.getPasswd());
		if (employee.isMale()) {
			rdbMale.setSelected(true);
		}else {
			rdbFeMale.setSelected(true);
		}
		
		for(String hobby: employee.getHobbys()) {
			if (chckBaseBall.getText().equals(hobby)) {
				chckBaseBall.setSelected(true);
			}
			if (chckBowling.getText().equals(hobby)) {
				chckBowling.setSelected(true);
			}
			if (chckSong.getText().equals(hobby)) {
				chckSong.setSelected(true);
			}
		}
		spnSalary.setValue(employee.getSalary());
	}
	
	@Override
	public void clearComponent() {
		tfEmpNo.setText("");
		tfEmpName.setText("");
		cmbDept.setSelectedIndex(-1);
		cmbTitle.setSelectedIndex(-1);
		tfJoinDate.setDate(new Date());
		pfPw1.setText("");
		pfPw2.setText("");
		lblResult.setText("");
		rdbMale.setSelected(true);
		chckBaseBall.setSelected(false);
		chckBowling.setSelected(false);
		chckSong.setSelected(false);
		spnSalary.setValue(1500000);
	}

	public void validCheck() {
		try {
			if (tfEmpNo.getText().trim().equals("")) {
				throw new Exception("사원번호가 비었습니다.");
			} //사원번호
			if (tfEmpName.getText().trim().equals("")) {
				throw new Exception("사원명이 비었습니다.");
			} //사원명
			if (cmbDept.getSelectedIndex()==-1) {
				throw new Exception("부서를 선택하세요.");
			}//부서
			if (cmbTitle.getSelectedIndex()==-1) {
				throw new Exception("직책을 선택하세요.");
			}//직책
			
			if (tfJoinDate.getDate()==null) {
				throw new Exception("입사일자 확인하세요.");
			}
			
			if (!lblResult.getText().equals("일치")) {
				throw new Exception("비밀번호 확인하세요.");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@Override
	protected JTextField getTfNo() {
		return tfEmpNo;
	}
}
