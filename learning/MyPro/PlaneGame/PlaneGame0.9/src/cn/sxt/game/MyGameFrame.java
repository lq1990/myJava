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
 * 飞机游戏的主窗口
 * 
 * @author china
 *
 */
public class MyGameFrame extends Frame {

	Image planeImg = GameUtil.getImage("images/plane_small.png");
	Image bg = GameUtil.getImage("images/bg.png");

	Plane plane = new Plane(planeImg, 250, 250);
	Shell[] shells = new Shell[50]; // 画多个炮弹，使用数组
	Explode bao;
	Date startTime = new Date();
	Date endTime;
	int period;

	@Override
	public void paint(Graphics g) { // 自动被调用，g相当于一支画笔
		Color c = g.getColor();
		g.drawImage(bg, 0, 0, null);

		plane.drawSelf(g);

		// 画出所有炮弹
		for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);

			// 飞机和炮弹的 碰撞检测
			boolean peng = shells[i].getRect().intersects(plane.getRect());

			if (peng) {
//				System.out.println("撞了");
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
				g.drawString("游戏时间：" + period + "秒", 120, 250);
			}
		}
		g.setColor(c);
	}

	// 使用 update方法，使得 Frame 画图不闪烁了。
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
	 * 帮助我们反复的重画窗口。 定义内部类。可以方便使用 MyGameFrame类中的属性方法
	 */
	class PaintThread extends Thread {

		@Override
		public void run() {
			while (true) {
//				System.out.println("repaint once");
				repaint();

				try {
					Thread.sleep(40); // 40ms, 即 1s内25个图片
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 内部类，键盘监听
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
		this.setTitle("我的游戏");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);

		// 当手动关闭窗口时，可以使 terminate
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 0表示正常结束
			}
		});

		new PaintThread().start(); // 启动重画窗口的线程
		addKeyListener(new KeyMonitor()); // 添加键盘监听者

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
