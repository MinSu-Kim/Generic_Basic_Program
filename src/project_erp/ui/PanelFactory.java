package project_erp.ui;

import java.util.List;

import project_erp.dto.Department;
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

	@SuppressWarnings("unchecked")
	public static <T> AbstractContent<T> createContent(DtoType type, List<T> itemList, List<Department> deptList, List<Title> titleList) {
		AbstractContent<T> content = null;
		switch (type) {
			case TITLE:
				content = (AbstractContent<T>) new PanelTitle();
				break;
			case DEPARTMENT:
				content = (AbstractContent<T>) new PanelDepartment();
				break;
			case EMPLOYEE:
				content = (AbstractContent<T>) new PanelEmployee();
				content.setTitleList(titleList);
				content.setDeptList(deptList);
				break;
		}
		return content;
	}

	@SuppressWarnings("unchecked")
	public static <T> AbstractList<T> createList(DtoType type, List<T> itemList) {
		AbstractList<T> list = null;
		switch (type) {
			case TITLE:
				list =  (AbstractList<T>) new PanelTitleList();
				list.setItemList(itemList);
				break;
			case DEPARTMENT:
				list =  (AbstractList<T>) new PanelDeptList();
				list.setItemList(itemList);
				break;
			case EMPLOYEE:
				list =  (AbstractList<T>) new PanelEmpList();
				list.setItemList(itemList);
				break;
		}
		return list;
	}
	

}
