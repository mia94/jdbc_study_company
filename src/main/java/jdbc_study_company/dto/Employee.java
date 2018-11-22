package jdbc_study_company.dto;

public class Employee {
	private String empNo;
	private String empName;
	private int title;
	private int salary;
	private int gender;
	private int dno;
	private int joinDate;
	
	public Employee() {

	}
	
	public Employee(String empNo) {
		this.empNo = empNo;
	}
	
	
	public Employee(String empNo, String empName, int title, int salary, int gender, int dno, int joinDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.salary = salary;
		this.gender = gender;
		this.dno = dno;
		this.joinDate = joinDate;
	}

	//get set
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

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public int getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(int joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return String.format("Employee [%s, %s, %s, %s, %s, %s, %s]", empNo, empName, title, salary, gender, dno, joinDate);
	}
	
	
}
