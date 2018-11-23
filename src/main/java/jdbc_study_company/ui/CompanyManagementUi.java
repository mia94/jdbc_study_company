package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompanyManagementUi extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnEmployeeMangement;
	private JButton btnDepartmentManagement;
	private JButton btnTitleManagement;
	private EmployeeManagementUi empUi;
	private DepartmentManagementUi deptUi;
	private TitleManagementUi titleUi;

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
		
		btnEmployeeMangement = new JButton("사원관리");
		btnEmployeeMangement.addActionListener(this);
		panel.add(btnEmployeeMangement);
		
		btnDepartmentManagement = new JButton("부서관리");
		btnDepartmentManagement.addActionListener(this);
		panel.add(btnDepartmentManagement);
		
		btnTitleManagement = new JButton("직책관리");
		btnTitleManagement.addActionListener(this);
		panel.add(btnTitleManagement);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitleManagement) {
			do_btnTitleManagement_actionPerformed(e);
		}
		if (e.getSource() == btnDepartmentManagement) {
			do_btnDepartmentManagement_actionPerformed(e);
		}
		if (e.getSource() == btnEmployeeMangement) {
			do_btnEmployeeMangement_actionPerformed(e);
		}
	}
	protected void do_btnEmployeeMangement_actionPerformed(ActionEvent e) {
		if(empUi==null) {
			empUi = new EmployeeManagementUi();
		}
		empUi.setVisible(true);
		
	}
	protected void do_btnDepartmentManagement_actionPerformed(ActionEvent e) {
		if(deptUi==null) {
			deptUi = new DepartmentManagementUi();
		}
		deptUi.setVisible(true);
		
	}
	protected void do_btnTitleManagement_actionPerformed(ActionEvent e) {
		if(titleUi==null) {
			titleUi = new TitleManagementUi();
		}
		titleUi.setVisible(true);
	}
	
}



















