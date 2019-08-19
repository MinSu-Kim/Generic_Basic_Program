package project_erp;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ErpMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataFileMgn dfm = new DataFileMgn();
					
					ErpFrame frame = new ErpFrame();
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							dfm.save();
							JOptionPane.showMessageDialog(null, "저장되었습니다.");
						}						
					});
					dfm.load();
					frame.setDataFileMgn(dfm);
//					frame.createPanels();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

}
