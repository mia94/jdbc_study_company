package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import jdbc_study_company.dto.Employee;
import jdbc_study_company.dto.Title;
import jdbc_study_company.service.EmployeeService;
import jdbc_study_company.ui.list.EmployeePanel;
import javax.swing.SpinnerNumberModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class EmployeeManagementUi extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmpNo;
	private JTextField tfEmpName;
	private JTextField tfJoinDate;
	
	private EmployeePanel empPanel;
	private EmployeeService service;
	
	List<Employee> list;
	private JComboBox cmbTitle;
	/**
	 * Create the frame.
	 */
	public EmployeeManagementUi() {
		service = new EmployeeService();
		initComponents();
	}
	private void initComponents() {
		setTitle("사원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel pInput = new JPanel();
		contentPane.add(pInput);
		pInput.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		pInput.add(lblNewLabel_1);
		
		JLabel lblEmpNo = new JLabel("번호");
		lblEmpNo.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblEmpNo);
		
		tfEmpNo = new JTextField();
		tfEmpNo.setEditable(false);
		//다음번호 자동 추가해두기
		try {
			tfEmpNo.setText(service.nextNoEmpNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pInput.add(tfEmpNo);
		tfEmpNo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		pInput.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		pInput.add(label);
		
		JLabel lblEmpName = new JLabel("사원명");
		lblEmpName.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblEmpName);
		
		tfEmpName = new JTextField();
		tfEmpName.setColumns(10);
		pInput.add(tfEmpName);
		
		JLabel label_2 = new JLabel("");
		pInput.add(label_2);
		
		JLabel label_3 = new JLabel("");
		pInput.add(label_3);
		
		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblTitle);
		
		//직책 comboBox
		try {
			DefaultComboBoxModel<Title> titleModel = new DefaultComboBoxModel<>(new Vector<>(service.selectTitleByAll()));
			cmbTitle = new JComboBox<>(titleModel);
			cmbTitle.setSelectedIndex(-1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pInput.add(cmbTitle);
		
		JLabel lblNewLabel_3 = new JLabel("");
		pInput.add(lblNewLabel_3);
		
		JLabel label_5 = new JLabel("");
		pInput.add(label_5);
		
		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblSalary);
		
		JSpinner spinSalary = new JSpinner();
		spinSalary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		pInput.add(spinSalary);
		
		JLabel lblNewLabel_4 = new JLabel("");
		pInput.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		pInput.add(lblNewLabel_5);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblGender);
		
		JPanel panel_3 = new JPanel();
		pInput.add(panel_3);
		
		JRadioButton rdbtnMale = new JRadioButton("남");
		rdbtnMale.setSelected(true);
		panel_3.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여");
		panel_3.add(rdbtnFemale);
		panel_3.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{rdbtnMale, rdbtnFemale}));
		
		JLabel lblNewLabel_6 = new JLabel("");
		pInput.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		pInput.add(lblNewLabel_7);
		
		JLabel lblDept = new JLabel("부서");
		lblDept.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblDept);
		
		JComboBox cmbDept = new JComboBox();
		pInput.add(cmbDept);
		
		JLabel lblNewLabel_9 = new JLabel("");
		pInput.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		pInput.add(lblNewLabel_10);
		
		JLabel lblJoinDate = new JLabel("입사일");
		lblJoinDate.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblJoinDate);
		
		tfJoinDate = new JTextField();
		pInput.add(tfJoinDate);
		tfJoinDate.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("");
		pInput.add(lblNewLabel_13);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("");
		pBtn.add(lblNewLabel_12);
		
		JButton btnOk = new JButton("추가");
		pBtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
		
		//테이블 뜨는 곳
		list = service.selectEmployeeByAll();
		EmployeePanel empPanel = new EmployeePanel();
		empPanel.setList(list);
		empPanel.loadDatas();
		
		contentPane.add(empPanel);
	}

}
