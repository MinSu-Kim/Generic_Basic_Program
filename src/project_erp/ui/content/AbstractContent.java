package project_erp.ui.content;

import javax.swing.JPanel;
import javax.swing.JTextField;

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
}
