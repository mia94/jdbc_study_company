package jdbc_study_company.dto;

import java.util.Date;

public class Employee {
	private String empNo;
	private String empName;
	private Title title;
	private int salary;
	private Gender gender;
	private Department deptNo;
	private Date joinDate;
	
	public Employee() {
 
	}
	
	public Employee(String empNo) {
		this.empNo = empNo;
	}

	public Employee(String empNo, String empName, Title title, int salary, Gender gender, Department deptNo,
			Date joinDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.salary = salary;
		this.gender = gender;
		this.deptNo = deptNo;
		this.joinDate = joinDate;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Department getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Department deptNo) {
		this.deptNo = deptNo;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return String.format("Employee [%s, %s, %s, %s, %s, %s, %s]",empNo, empName, title, salary, gender, deptNo, joinDate);
	}
	
	
}
