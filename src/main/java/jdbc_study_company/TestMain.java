package jdbc_study_company;

public class TestMain {

	public static void main(String[] args) {
		//부서,직책번호에서 다음번호 자도 호출
		String deptNo = "D004";
		int no = Integer.parseInt(deptNo.substring(1))+1;
		
		System.out.println(no);
		
		String nextNo = String.format("D%03d", no);
		System.out.println(nextNo);
	}

}
