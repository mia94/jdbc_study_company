package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import jdbc_study_company.dto.Department;
import jdbc_study_company.service.DepartmentService;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DepartmentManagementUi extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfDeptNo;
	private JTextField tfDeptName;
	private JTextField tfFloor;
	
	private DepartmentService service;
	private DepartmentPanel deptPanel;
	private JButton btnAdd;
	private JButton btnCancel;
	
	List<Department> list;

	/**
	 * Create the frame.
	 */
	public DepartmentManagementUi() {
		service = new DepartmentService();
		initComponents();
	}
	private void initComponents() {
		setTitle("부서관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		tfDeptNo.setEditable(false);
		
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
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel_3.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_3.add(lblNewLabel_3);
		
		list = service.selectDepartmentByAll();
		deptPanel = new DepartmentPanel();
		deptPanel.setList(list);
		deptPanel.loadDatas();
		
		//popup메뉴
		deptPanel.setPopupMenu(createDeptPopUpMenu());
		
//		pDeptTable.add(deptPanel);
		contentPane.add(deptPanel, BorderLayout.CENTER);
	}

	private JPopupMenu createDeptPopUpMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//수정하려는 dept정보 가져오기
				Department item = deptPanel.getSelectedDept();
				tfDeptNo.setText(item.getDeptNo());
				tfDeptName.setText(item.getDaptName());
				//버튼 바꾸기
				btnAdd.setText("수정");
				
				
			}
		});
		popMenu.add(updateItem);
		
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 삭제할 dept정보 가져오기
				try {
					service.deleteDept(deptPanel.getSelectedDept());
					deptPanel.setList(service.selectDepartmentByAll());
					deptPanel.loadDatas();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		popMenu.add(delItem);

		
		return popMenu;
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
		//추가버튼 실행
		Department item = getItem();
		try {
			service.insertDept(item);//값 추가
			deptPanel.setList(service.selectDepartmentByAll());
			deptPanel.loadDatas();
			cleartf();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private Department getItem() {
		String deptNo = tfDeptNo.getText().trim();
		String deptName = tfDeptName.getText().trim();
		int floor = Integer.parseInt(tfFloor.getText().trim());
		return new Department(deptNo, deptName, floor);
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		//취소버튼 실행 초기화
		cleartf();
	}
	
	private void cleartf() {
		tfDeptNo.setText("");
		tfDeptName.setText("");
		tfFloor.setText("");
	}
}
















