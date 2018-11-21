package jdbc_study_company.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DepartmentPanel extends JPanel {
	private JTable table;

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
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"번호", "부서명", "위치"
			}
		));
		scrollPane.setViewportView(table);
	}

}
