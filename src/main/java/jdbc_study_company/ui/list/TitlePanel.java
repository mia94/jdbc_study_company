package jdbc_study_company.ui.list;

import jdbc_study_company.dto.Title;

@SuppressWarnings("serial")
public class TitlePanel extends AbstractPanel<Title> {



	protected Object[] getItemrow(Title item) {
		return new Object[] {
				item.gettNo(),
				item.gettName()
		};
	}
	
	protected String[] getColumnName() {
		return new String[] {
			"번호", "직책"
		};
	}

	protected Title getItem(int selectRow) {
		String tNo = (String)table.getModel().getValueAt(selectRow, 0);
		String tName = (String)table.getModel().getValueAt(selectRow, 1);
		return new Title(tNo, tName);
	}
	

}



















