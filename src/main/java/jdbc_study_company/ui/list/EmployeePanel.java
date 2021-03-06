package jdbc_study_company.ui.list;

import java.util.Date;

import jdbc_study_company.dto.Department;
import jdbc_study_company.dto.Employee;
import jdbc_study_company.dto.Gender;
import jdbc_study_company.dto.Title;

@SuppressWarnings("serial")
public class EmployeePanel extends AbstractPanel<Employee> {
	public EmployeePanel() {
	}

	@Override
	protected Object[] getItemrow(Employee item) {//테이블에 출력
		return new Object[] {
				item.getEmpNo(),
				item.getEmpName(),
				item.getTitle().gettName(),
				item.getSalary(),
				(item.getGender())==Gender.FEMALE?"여자":"남자",
				item.getDeptNo().getDeptName(),
				item.getJoinDate()
		};
	}
 
	@Override
	protected String[] getColumnName() {
		// TODO Auto-generated method stub
		return new String[] {
				"번호","사원명","직책","접대","성별","부서","입사일"
			};
	}

	@Override
	protected Employee getItem(int selectedRow) {
		String empNo = (String) table.getValueAt(selectedRow, 0);
		Employee newEmp = new Employee(empNo);
	 	int index = list.indexOf(newEmp); 
	 	return list.get(index);
		/*String empName = (String) table.getModel().getValueAt(selectedRow, 1);
		Title title = (Title) table.getModel().getValueAt(selectedRow, 3);
		int salary = (int) table.getModel().getValueAt(selectedRow, 4);
		Gender gender = (Gender) table.getModel().getValueAt(selectedRow, 5);
		Department deptNo = (Department) table.getModel().getValueAt(selectedRow, 6);
		Date joinDate = (Date) table.getModel().getValueAt(selectedRow, 6);*/
		
	}

}














