package cn.sxt.game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * �ɻ���Ϸ��������
 * @author china
 *
 */
public class MyGameFrame extends JFrame {
	/**
	 * init frame
	 */
	public void launchFrame() {
		this.setTitle("�ҵ���Ϸ");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(300, 300);
		
		// ���ֶ��رմ���ʱ������ʹ terminate
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 0��ʾ��������
			}
		});
	}
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}
