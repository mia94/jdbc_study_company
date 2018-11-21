package jdbc_study_company.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc_study_company.dto.Department;

public class DepartmentPanel extends JPanel {
	private JTable table;
	private List<Department> list;

	/**
	 * Create the panel.
	 */
	public DepartmentPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			getDatas(),
			getColumnName()
		));
		scrollPane.setViewportView(table);
	}
	public Object[][] getDatas() {
		Object[][] datas = new Object[list.size()+1][];
		for(int i=0;i<list.size();i++) {
			datas[i] = getDepartmentrow(list.get(i));
		}
		datas[list.size()] = getTotal();
		return datas;
	}
	private Object[] getTotal() {
		
		return null;
	}
	private Object[] getDepartmentrow(Department item) {
		return new Object[] {
			item.getDeptNo(),
			item.getDaptName(),
			item.getFloor()
		};
	}
	public String[] getColumnName() {
		return new String[] {
			"번호", "부서명", "위치"
		};
	}

}
















