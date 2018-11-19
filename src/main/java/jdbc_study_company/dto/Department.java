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
	
	
	
}
