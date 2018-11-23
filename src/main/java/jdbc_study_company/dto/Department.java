package jdbc_study_company.dto;

public class Department {
	private String deptNo;
	private String deptName;
	private int floor;
	
	public Department() {
		
	}

	public Department(String deptNo, String deptName, int floor) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}
	
	public Department(String deptName, int floor) {
		this.deptName = deptName;
		this.floor = floor;
	}

	public Department(String deptNo) {
		this.deptNo = deptNo;
	}

	//GET SET
	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String daptName) {
		this.deptName = daptName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", deptName, floor);
	}
	

	
}
