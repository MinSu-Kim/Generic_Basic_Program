package project_erp.ui.content;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import project_erp.dto.Department;
import project_erp.dto.Title;

@SuppressWarnings("serial")
public abstract class AbstractContent<T> extends JPanel{
	public AbstractContent(String title) {	
		initComponents(title);
	}
	
	protected abstract void initComponents(String title);
	public abstract T getItem();
	
	public abstract void setItem(T item);
	
	public abstract void clearComponent();

	protected abstract JTextField getTfNo();
	
	public abstract void setDeptList(List<Department> deptList);
	
	public abstract void setTitleList(List<Title> titleList);
}
