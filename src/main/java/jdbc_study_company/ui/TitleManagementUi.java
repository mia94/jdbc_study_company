package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TitleManagementUi extends JFrame {

	private JPanel contentPane;
	private JTextField tfTno;
	private JTextField tfTname;

	/**
	 * Create the frame.
	 */
	public TitleManagementUi() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTno = new JLabel("번호");
		lblTno.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTno);
		
		tfTno = new JTextField();
		panel.add(tfTno);
		tfTno.setColumns(10);
		
		JLabel lblTname = new JLabel("직책명");
		lblTname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTname);
		
		tfTname = new JTextField();
		tfTname.setColumns(10);
		panel.add(tfTname);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnAdd = new JButton("추가");
		panel_2.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		panel_2.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
	}

}
