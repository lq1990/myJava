package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;

/**
 * �ɻ���Ϸ��������
 * 
 * @author china
 *
 */
public class MyGameFrame extends Frame {

	Image planeImg = GameUtil.getImage("images/plane_small.png");
	Image bg = GameUtil.getImage("images/bg.png");

	Plane plane = new Plane(planeImg, 250, 250);
	Shell[] shells = new Shell[50]; // ������ڵ���ʹ������
	Explode bao;
	Date startTime = new Date();
	Date endTime;
	int period;

	@Override
	public void paint(Graphics g) { // �Զ������ã�g�൱��һ֧����
		Color c = g.getColor();
		g.drawImage(bg, 0, 0, null);

		plane.drawSelf(g);

		// ���������ڵ�
		for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);

			// �ɻ����ڵ��� ��ײ���
			boolean peng = shells[i].getRect().intersects(plane.getRect());

			if (peng) {
//				System.out.println("ײ��");
				plane.live = false;
				if (bao == null) {
					bao = new Explode(plane.x, plane.y);
					endTime = new Date();
					period = (int) (endTime.getTime() - startTime.getTime()) / 1000;
				}
				bao.draw(g);
			}

			if (!plane.live) {
				g.setColor(Color.WHITE);
				g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
				g.drawString("��Ϸʱ�䣺" + period + "��", 120, 250);
			}
		}
		g.setColor(c);
	}

	// ʹ�� update������ʹ�� Frame ��ͼ����˸�ˡ�
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	/*
	 * �������Ƿ������ػ����ڡ� �����ڲ��ࡣ���Է���ʹ�� MyGameFrame���е����Է���
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
	 * 
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

		// init 50 shells
		for (int i = 0; i < shells.length; i++) {
			shells[i] = new Shell();
		}
	}

	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}
