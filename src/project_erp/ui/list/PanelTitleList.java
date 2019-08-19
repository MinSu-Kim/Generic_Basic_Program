package project_erp.ui.list;

import javax.swing.SwingConstants;

import project_erp.dto.Title;

@SuppressWarnings("serial")
public class PanelTitleList extends AbstractList<Title> {
	
	public PanelTitleList() {
		super("직책");
	}
	
	@Override
	public void tableWidthAndAlign() {
		//컬럼의 폭 조정
		tableSetWidth(100, 200);
		//컬럼의 데이터 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1);		
	}
	
	@Override
	public String[] getColumnNames() {
		return new String[] {"직책 번호", "직책명"};
	}

	@Override
	protected Object[] getItemToArray(Title t) {
		return new Object[] {t.getTitleNo(), t.getTitleName()};
	}

}
