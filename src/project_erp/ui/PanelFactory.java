package project_erp.ui;

import java.util.List;

import project_erp.DtoType;
import project_erp.dto.Department;
import project_erp.dto.Employee;
import project_erp.dto.Title;
import project_erp.ui.content.AbstractContent;
import project_erp.ui.content.PanelDepartment;
import project_erp.ui.content.PanelEmployee;
import project_erp.ui.content.PanelTitle;
import project_erp.ui.list.AbstractList;
import project_erp.ui.list.PanelDeptList;
import project_erp.ui.list.PanelEmpList;
import project_erp.ui.list.PanelTitleList;

public class PanelFactory {

	public static <T> AbstractContent<?> createContent(DtoType type, List<T> itemList, List<Department> deptList, List<Title> titleList) {
		switch (type) {
		case TITLE:
			return new PanelTitle();
		case DEPARTMENT:
			return new PanelDepartment();
		case EMPLOYEE:
			PanelEmployee emp= new PanelEmployee();
			emp.setTitleList(titleList);
			emp.setDeptList(deptList);
			return emp;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> AbstractList<?> createList(DtoType type, List<T> itemList, List<Department> deptList, List<Title> titleList) {
		switch (type) {
		case TITLE:
			PanelTitleList ptl =  new PanelTitleList();
			ptl.setItemList((List<Title>) itemList);
			return ptl;
		case DEPARTMENT:
			PanelDeptList pdl =  new PanelDeptList();
			pdl.setItemList((List<Department>) itemList);
			return pdl;
		case EMPLOYEE:
			PanelEmpList pel =  new PanelEmpList();
			pel.setItemList((List<Employee>) itemList);
			return pel;
		}
		return null;
	}
	

}
