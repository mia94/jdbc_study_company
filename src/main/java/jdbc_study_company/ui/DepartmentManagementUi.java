package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DepartmentManagementUi extends JFrame {

	private JPanel contentPane;
	private JTextField tfDeptNo;
	private JTextField tfDeptName;
	private JTextField tfFloor;


	/**
	 * Create the frame.
	 */
	public DepartmentManagementUi() {
		initComponents();
	}
	private void initComponents() {
		setTitle("부서관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblDeptNo = new JLabel("번호");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDeptNo);
		
		tfDeptNo = new JTextField();
		panel.add(tfDeptNo);
		tfDeptNo.setColumns(10);
		
		JLabel lblDeptName = new JLabel("부서명");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDeptName);
		
		tfDeptName = new JTextField();
		tfDeptName.setColumns(10);
		panel.add(tfDeptName);
		
		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblFloor);
		
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		panel.add(tfFloor);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("추가");
		panel_2.add(btnAdd);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnCancel = new JButton("취소");
		panel_3.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3);
		
		DepartmentPanel panel_1 = new DepartmentPanel();
		contentPane.add(panel_1);
	}

}
