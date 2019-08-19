package project_erp.ui.list;

import javax.swing.SwingConstants;

import project_erp.dto.Department;

@SuppressWarnings("serial")
public class PanelDeptList extends AbstractList<Department> {
	public PanelDeptList() {
		super("부서");
	}

	@Override
	public void tableWidthAndAlign() {
		// 컬럼의 폭 조정
		tableSetWidth(100, 200, 100);
		// 컬럼의 데이터 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2);
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "부서번호", "부서명", "위치(층)" };
	}

	@Override
	protected Object[] getItemToArray(Department t) {
		return new Object[] { t.getDeptNo(), t.getDeptName(), t.getFloor() };
	}
}
