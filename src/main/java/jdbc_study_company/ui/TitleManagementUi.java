package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_study_company.dto.Title;
import jdbc_study_company.service.TitleService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class TitleManagementUi extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfTno;
	private JTextField tfTname;
	private JButton btnAdd;
	private JButton btnCancel;
	
	private TitleService service;

	/**
	 * Create the frame.
	 */
	public TitleManagementUi() {
		service = new TitleService();
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 10));
		
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
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_2.add(btnCancel);
		
		TitlePanel panel_1 = new TitlePanel();
		contentPane.add(panel_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			do_btnAdd_actionPerformed(e);
		}
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		//추가버튼 눌렀을 시 
		Title item = getItem();
		try {
			service.insertTitle(item);
			service.selectTitleByAll();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private Title getItem() {
		String tNo = tfTno.getText().trim();
		String tName = tfTname.getText().trim();
		return new Title(tNo, tName);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		//취소버튼 입력 시
		tfTno.setText("");
		tfTname.setText("");
	}
}





















