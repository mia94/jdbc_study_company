package jdbc_study_company.dto;

public class Title {
	private String tNo;
	private String tName;
	
	public Title() {
		
	}
	
	public Title(String tNo, String tName) {
		this.tNo = tNo;
		this.tName = tName;
	}
	//get set
	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}
	//toString
	@Override
	public String toString() {
		return String.format("Title [%s, %s]", tNo, tName);
	}
	
	
}
