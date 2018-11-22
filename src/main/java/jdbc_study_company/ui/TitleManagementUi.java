package jdbc_study_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.SeparatorMenuItem;
import jdbc_study_company.dto.Title;
import jdbc_study_company.service.TitleService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class TitleManagementUi extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfTno;
	private JTextField tfTname;
	private JButton btnAdd;
	private JButton btnCancel;
	
	private TitleService service;
	private TitlePanel titlePanel;
	
	List<Title> list;

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
		
		JPanel pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblTno = new JLabel("번호");
		lblTno.setHorizontalAlignment(SwingConstants.RIGHT);
		pContent.add(lblTno);
		
		tfTno = new JTextField();
		tfTno.setEditable(false);
		//번호 자동 추가
		try {
			tfTno.setText(service.nextNoTitle());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		pContent.add(tfTno);
		tfTno.setColumns(10);
		
		JLabel lblTname = new JLabel("직책명");
		lblTname.setHorizontalAlignment(SwingConstants.RIGHT);
		pContent.add(lblTname);
		
		tfTname = new JTextField();
		tfTname.setColumns(10);
		pContent.add(tfTname);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		try {
			list = service.selectTitleByAll();
			titlePanel = new TitlePanel();
			titlePanel.setList(list);
			titlePanel.loadDatas();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//popup메뉴 추가
		titlePanel.setPopupMenu(createTitlePopUpMenu());
		
		contentPane.add(titlePanel, BorderLayout.CENTER);
	}

	private JPopupMenu createTitlePopUpMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		//수정
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Title item = titlePanel.getSelectTitle();
				setItem(item);
				btnAdd.setText("수정");
			}	
		});
		popMenu.add(updateItem);
		
		JMenuItem delItem = new JMenuItem("삭제");
		delItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					service.deleteTitle(titlePanel.getSelectTitle());
					titlePanel.setList(service.selectTitleByAll());
					titlePanel.loadDatas();
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
			if(btnAdd.getText()=="추가") {
				do_btnAdd_actionPerformed(e);
			}else {
				do_btnUpdate_actionPerformed(e);
			}
			
		}
	}
	private void do_btnUpdate_actionPerformed(ActionEvent e) {
		Title item = getItem();
		try {
			service.updateTitle(item);
			titlePanel.setList(service.selectTitleByAll());
			titlePanel.loadDatas();
			cleartf();
			btnAdd.setText("추가");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	private void cleartf() {
		try {
			tfTno.setText(service.nextNoTitle());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tfTname.setText("");
	}
	
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		//추가버튼 눌렀을 시 
		Title item = getItem();
		try {
			service.insertTitle(item);
			titlePanel.setList(service.selectTitleByAll());
			titlePanel.loadDatas();
			cleartf();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private Title getItem() {
		String tNo = tfTno.getText().trim();
		String tName = tfTname.getText().trim();
		return new Title(tNo, tName);
	}
	private void setItem(Title item) {
		tfTno.setText(item.gettNo());
		tfTname.setText(item.gettName());
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		//취소버튼 입력 시
		cleartf();
	}
}





















