package project_erp.ui.list;

import javax.swing.SwingConstants;

import project_erp.dto.Employee;

@SuppressWarnings("serial")
public class PanelEmpList extends AbstractList<Employee> {

	public PanelEmpList() {
		super("사원");
	}

	@Override
	public void tableWidthAndAlign() {
		// 컬럼의 폭 조정 "사원번호", "사원명", "부서", "직책", "성별", "취미", "입사일", "급여"
		tableSetWidth(100, 200, 100, 100, 100, 150, 100, 100);
		// 컬럼의 데이터 정렬
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		tableCellAlign(SwingConstants.RIGHT, 7);
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] { "사원번호", "사원명", "부서", "직책", "성별", "취미", "입사일", "급여" };
	}

	@Override
	protected Object[] getItemToArray(Employee t) {
		return new Object[] {
				t.getEmpNo(), 
				t.getEmpName(), 
				String.format("%s(%d층)", t.getDept().getDeptName(), t.getDept().getDeptNo()),
				t.getTitle().getTitleName(), 
				t.isMale()?"남":"여", 
				t.getHobbys(), 
				String.format("%tF", t.getJoinDate()), 
				String.format("%,d", t.getSalary())};
	}
}
