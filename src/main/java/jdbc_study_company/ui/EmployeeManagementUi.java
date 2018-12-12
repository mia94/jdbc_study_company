package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import jdbc_study_company.dto.Department;
import jdbc_study_company.dto.Employee;
import jdbc_study_company.dto.Gender;
import jdbc_study_company.dto.Title;
import jdbc_study_company.jdbc.LogUtil;
import jdbc_study_company.service.EmployeeService;
import jdbc_study_company.ui.list.EmployeePanel;
import javax.swing.SpinnerNumberModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class EmployeeManagementUi extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfEmpNo;
	private JTextField tfEmpName;
	private JTextField tfJoinDate;
	
	private EmployeePanel empPanel;
	private EmployeeService service;
	
	List<Employee> list;
	private JComboBox<Title> cmbTitle;
	private JComboBox<Department> cmbDept;
	private JButton btnOk;
	private JButton btnCancel;
	private JSpinner spinSalary;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private final ButtonGroup buttonGroup = new ButtonGroup(); 
	/**
	 * Create the frame.
	 */
	public EmployeeManagementUi() {
		service = new EmployeeService();
		initComponents(); 
	}
	private void initComponents() {
		setTitle("사원관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		spinSalary = new JSpinner();
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
		
		rdbtnMale = new JRadioButton("남");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setSelected(true);
		panel_3.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여");
		buttonGroup.add(rdbtnFemale);
		panel_3.add(rdbtnFemale);
		panel_3.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{rdbtnMale, rdbtnFemale}));
		
		JLabel lblNewLabel_6 = new JLabel("");
		pInput.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		pInput.add(lblNewLabel_7);
		
		JLabel lblDept = new JLabel("부서");
		lblDept.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblDept);
		
		//부서 ComboBox
		DefaultComboBoxModel<Department> deptModel = new DefaultComboBoxModel<>(new Vector<>(service.selectDeptByAll()));
		cmbDept = new JComboBox<>(deptModel);
		cmbDept.setSelectedIndex(-1);
		pInput.add(cmbDept);
		
		JLabel lblNewLabel_9 = new JLabel("");
		pInput.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		pInput.add(lblNewLabel_10);
		
		JLabel lblJoinDate = new JLabel("입사일");
		lblJoinDate.setHorizontalAlignment(SwingConstants.CENTER);
		pInput.add(lblJoinDate);
		
		tfJoinDate = new JTextField();
		tfJoinDate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//날짜
		tfJoinDate.setText(String.format("%tF", new Date()));
		pInput.add(tfJoinDate);
		tfJoinDate.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("");
		pInput.add(lblNewLabel_13);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("");
		pBtn.add(lblNewLabel_12);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		pBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		//테이블 뜨는 곳
		list = service.selectEmployeeByAll();
		empPanel = new EmployeePanel();
		empPanel.setList(list);
		empPanel.loadDatas();
		//popUp메뉴
		empPanel.setPopupMenu(createEmpPopUpMenu());
		
		contentPane.add(empPanel);
	}

	private JPopupMenu createEmpPopUpMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem =  new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Employee item = empPanel.getSelectedItem();
				setItem(item);
				btnOk.setText("수정");
			}
			
		});
		popMenu.add(updateItem);
		
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					service.deleteEmp(empPanel.getSelectedItem());
					empPanel.setList(service.selectEmployeeByAll());
					empPanel.loadDatas();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		popMenu.add(delItem);
		
		return popMenu;
	}
	
	private void cleartf() {
		tfEmpName.setText("");
		cmbTitle.setSelectedIndex(-1);
		spinSalary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		rdbtnMale.setSelected(true);
		cmbDept.setSelectedIndex(-1);
		tfJoinDate.setText(String.format("%tF", new Date()));
	}
	private void setItem(Employee item) {
		LogUtil.prnLog(item.getDeptNo().getDeptNo());
		tfEmpNo.setText(item.getEmpNo());
		tfEmpName.setText(item.getEmpName());
		spinSalary.setValue(item.getSalary());
		cmbTitle.setSelectedItem(item.getTitle());
		if(item.getGender()==Gender.FEMALE) {
			rdbtnFemale.setSelected(true);
		}else {
			rdbtnMale.setSelected(true);
		}
		cmbDept.setSelectedItem(item.getDeptNo());
		tfJoinDate.setText(String.format("%tF", item.getJoinDate()));
	}
	
	private Employee getItem() {
		String empNo = tfEmpNo.getText().trim();
		String empName = tfEmpName.getText().trim();
		Title title = (Title) cmbTitle.getSelectedItem();
		int salary = (int) spinSalary.getValue();
		Gender gender = null;
		if(rdbtnFemale.isSelected()) {
			gender = Gender.FEMALE;
		}else {
			gender = Gender.MALE;
		}
		Department deptNo = (Department) cmbDept.getSelectedItem();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date joinDate = null;
		try {
			joinDate = sdf.parse(tfJoinDate.getText().trim());//parse : date로 바꿔줌
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Employee(empNo, empName, title, salary, gender, deptNo, joinDate);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			if(btnOk.getText()=="추가") {
				do_btnOk_actionPerformed(e);
			}else {
				do_btnUpdate_actionPerformed(e);
			}
			
		}
	}
	
	private void do_btnUpdate_actionPerformed(ActionEvent e) {
		//수정버튼 클릭시
		Employee item = getItem();
		try {
			service.updateEmp(item);
			empPanel.setList(service.selectEmployeeByAll());
			empPanel.loadDatas();
			cleartf();
			btnOk.setText("추가");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		//btnOk입력시
		if(tfEmpName.getText().equals("")) {//문자열 비교는 equal사용하기!!!!!!
			JOptionPane.showMessageDialog(null, "사원명을 입력하세요.");
			return;
		}
		Employee item = getItem();
		try {
			service.insertEmp(item);
			empPanel.setList(service.selectEmployeeByAll());
			empPanel.loadDatas();
			cleartf();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		//btnCancel입력시
		cleartf();
	}
}













