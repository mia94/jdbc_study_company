package jdbc_study_company.ui.list;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc_study_company.dto.Department;

@SuppressWarnings("serial")
public abstract class AbstractPanel<T> extends JPanel {
	protected JScrollPane jScrollPane;
	protected JTable table;
	protected List<T> list;
	
	
	public void setList(List<T> list) {
		this.list = list;
	}
	/**
	 * Create the panel.
	 */
	public AbstractPanel() {
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
/*		LogUtil.prnLog("list.toString");
		LogUtil.prnLog(list.toString());*/
		return datas;
	}
	
	protected abstract Object[] getItemrow(T item);
	
	protected abstract String[] getColumnName();
	
	public void setPopupMenu(JPopupMenu PopUpMenu) {
		table.setComponentPopupMenu(PopUpMenu);
//		jScrollPane.setComponentPopupMenu(PopUpMenu);//테이블이 없을때도 팝업메뉴가 뜨도록
	}
	 
	public T getSelectedItem(){
		int selectedRow = table.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "해당정보를 선택하세요");
			return null;
		};
		return getItem(selectedRow);
	}
	protected abstract T getItem(int selectedRow);
}
















