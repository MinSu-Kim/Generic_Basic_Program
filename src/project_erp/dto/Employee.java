package project_erp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Employee  implements Serializable{
	private int empNo; // 사원번호
	private String empName; // 사원명
	private Department dept; // 소속부서
	private Title title; // 직책
	private boolean isMale; // 성별
	private List<String> hobbys; // 취미
	private Date joinDate; // 입사일
	private String passwd; // 비밀번호
	private int salary; // 급여

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName, Department dept, Title title, boolean isMale, List<String> hobbys,
			Date joinDate, String passwd, int salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.title = title;
		this.isMale = isMale;
		this.hobbys = hobbys;
		this.joinDate = joinDate;
		this.passwd = passwd;
		this.salary = salary;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public List<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(List<String> hobbys) {
		this.hobbys = hobbys;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empNo != other.empNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Employee [empNo=%s, empName=%s, dept=%s, title=%s, isMale=%s, hobbys=%s, joinDate=%s, passwd=%s, salary=%s]",
				empNo, empName, dept, title, isMale, hobbys, String.format("%tF", joinDate), passwd, salary);
	}

}
