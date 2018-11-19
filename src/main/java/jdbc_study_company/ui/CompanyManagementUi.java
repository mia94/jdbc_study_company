package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class CompanyManagementUi extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CompanyManagementUi() {
		initComponents();
	}
	private void initComponents() {
		setTitle("ERP관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnEmployeeMangement = new JButton("사원관리");
		panel.add(btnEmployeeMangement);
		
		JButton btnDepartmentManagement = new JButton("부서관리");
		panel.add(btnDepartmentManagement);
		
		JButton btnTitleManagement = new JButton("직책관리");
		panel.add(btnTitleManagement);
	}

}
