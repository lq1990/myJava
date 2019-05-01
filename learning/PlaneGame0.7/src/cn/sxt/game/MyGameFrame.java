package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * �ɻ���Ϸ��������
 * @author china
 *
 */
public class MyGameFrame extends JFrame {
	
	Image planeImg = GameUtil.getImage("images/plane_small.png");
	Image bg = GameUtil.getImage("images/bg.png");
	
	Plane plane = new Plane(planeImg, 250, 250);
	Shell shell = new Shell();
	
	@Override
	public void paint(Graphics g) { // �Զ������ã�g�൱��һ֧����
		g.drawImage(bg, 0, 0, null);
		
		plane.drawSelf(g);
		shell.draw(g);
		
	}
	
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(500, 500);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	/*
	 * �������Ƿ������ػ����ڡ�
	 *  �����ڲ��ࡣ���Է���ʹ��  MyGameFrame���е����Է���
	 */
	class PaintThread extends Thread {
		
		@Override
		public void run() {
			while (true) {
//				System.out.println("repaint once");
				repaint();
				
				try {
					Thread.sleep(40); // 40ms, �� 1s��25��ͼƬ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}
	
	/**
	 * �ڲ��࣬���̼���
	 * @author china
	 *
	 */
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("press "+e.getKeyCode());
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("release "+e.getKeyCode());
			plane.minusDirection(e);
		}
		
	}
	
	/**
	 * init frame
	 */
	public void launchFrame() {
		this.setTitle("�ҵ���Ϸ");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);
		
		// ���ֶ��رմ���ʱ������ʹ terminate
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 0��ʾ��������
			}
		});
		
		new PaintThread().start(); // �����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor()); // ��Ӽ��̼�����
	}
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}


