package jdbc_study_company;

import java.awt.EventQueue;

import jdbc_study_company.ui.DepartmentManagementUi;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagementUi frame = new DepartmentManagementUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}