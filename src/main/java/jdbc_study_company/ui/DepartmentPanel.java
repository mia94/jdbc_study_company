package jdbc_study_company.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc_study_company.dto.Department;
import jdbc_study_company.jdbc.LogUtil;

public class DepartmentPanel extends JPanel {
	private JTable table;
	private List<Department> list;
	
	
	public void setList(List<Department> list) {
		this.list = list;
	}
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
//		loadDatas();
		scrollPane.setViewportView(table);
	}
	public void loadDatas() {
		table.setModel(new DefaultTableModel(
			getDatas(),
			getColumnName()
		));
	}
	public Object[][] getDatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i=0;i<list.size();i++) {
			datas[i] = getDepartmentrow(list.get(i));
		}
/*		LogUtil.prnLog("list.toString");
		LogUtil.prnLog(list.toString());*/
		return datas;
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
















