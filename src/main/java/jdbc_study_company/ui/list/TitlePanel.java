package jdbc_study_company.ui.list;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc_study_company.dto.Title;

public class TitlePanel extends JPanel {
	private JScrollPane jScrollPane;
	private JTable table;
	private List<Title> list;

	public void setList(List<Title> list) {
		this.list = list;
	}
	/**
	 * Create the panel.
	 */
	public TitlePanel() {
		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
//		loadDatas();
		scrollPane.setViewportView(table);
	}
	public void loadDatas() {
		table.setModel(new DefaultTableModel(
			getDatas(),
			getColumnName()
		));
	}
	public Object[][] getDatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i=0;i<list.size();i++) {
			datas[i] = getItemrow(list.get(i));
		}
		return datas;
	}
	private Object[] getItemrow(Title item) {
		return new Object[] {
				item.gettNo(),
				item.gettName()
		};
	}
	public String[] getColumnName() {
		return new String[] {
			"번호", "직책"
		};
	}
	public void setPopupMenu(JPopupMenu PopUpMenu) {
		table.setComponentPopupMenu(PopUpMenu);
	}
	
	public Title getSelectedItem() {
		int selectRow = table.getSelectedRow();
		if(selectRow == -1) {
			JOptionPane.showMessageDialog(null, "해당정보를 선택하세요");
			return null;
		}
		String tNo = (String)table.getModel().getValueAt(selectRow, 0);
		String tName = (String)table.getModel().getValueAt(selectRow, 1);
		return new Title(tNo, tName);
	}
	

}



















