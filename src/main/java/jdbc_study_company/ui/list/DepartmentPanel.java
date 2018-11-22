package jdbc_study_company.ui.list;

import jdbc_study_company.dto.Department;

@SuppressWarnings("serial")
public class DepartmentPanel extends AbstractPanel<Department> {
	

	protected Object[] getItemrow(Department item) {
		return new Object[] {
			item.getDeptNo(),
			item.getDaptName(),
			item.getFloor()
		};
	}
	protected String[] getColumnName() {
		return new String[] {
			"번호", "부서명", "위치"
		};
	}
	
	
	protected Department getItem(int selectedRow) {
		String deptNo = (String)table.getModel().getValueAt(selectedRow, 0);
		String daptName = (String)table.getModel().getValueAt(selectedRow, 1);
		int floor = (int)table.getModel().getValueAt(selectedRow, 2);
		return new Department(deptNo, daptName, floor);
	}

}
















