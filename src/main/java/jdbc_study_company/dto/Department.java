package jdbc_study_company.dto;

public class Department {
	private String deptNo;
	private String daptName;
	private int floor;
	
	public Department() { 
		
	}

	public Department(String deptNo, String daptName, int floor) {
		super();
		this.deptNo = deptNo;
		this.daptName = daptName;
		this.floor = floor;
	}
	
	public Department(String daptName, int floor) {
		this.daptName = daptName;
		this.floor = floor;
	}

	public Department(String deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return String.format("Department [%s, %s, %s]", deptNo, daptName, floor);
	}
	//GET SET
	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDaptName() {
		return daptName;
	}

	public void setDaptName(String daptName) {
		this.daptName = daptName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
}
