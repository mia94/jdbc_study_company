package jdbc_study_company;

import java.awt.EventQueue;

import jdbc_study_company.ui.CompanyManagementUi;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyManagementUi frame = new CompanyManagementUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}
}