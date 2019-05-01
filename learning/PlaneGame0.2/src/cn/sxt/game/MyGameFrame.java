package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * �ɻ���Ϸ��������
 * @author china
 *
 */
public class MyGameFrame extends JFrame {
	
	Image ball = GameUtil.getImage("images/ball.png");
	
	@Override
	public void paint(Graphics g) { // �Զ������ã�g�൱��һ֧����
		Font f = g.getFont();
		Color c = g.getColor();
		g.setColor(Color.BLUE); // ������ɫʱ����ȫ��Ӱ��g
		
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 300);
		g.fillRect(100, 100, 40, 40);
		g.setColor(Color.red);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		
		g.drawString("����˭��", 200, 200);
		g.drawImage(ball, 250, 250, null);
		
		
		g.setColor(c); // ��ԭ��ԭʼ����ɫ
		g.setFont(f);
	} 
	
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
