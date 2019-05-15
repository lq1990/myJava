
import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame {

	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

	double x = 100; // С��ĺ�����
	double y = 100; // С���������
	
	double degree = 3.14/3; // ���� ��λ

	// �����ڵķ�����ע������img�����أ�������ʾ������С��������󻯼�����ʾimg�ˡ�
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ�Σ�");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int) x, (int) y, null);
		
		x = x + 20*Math.cos(degree);
		y = y + 20*Math.sin(degree);
		
		// �������±߽�
		if (y >= 611-53-35 || y <= 53) {
			degree = -degree;
		}
		
		// �������ұ߽�
		if (x < 53 || x > 1209-53-35 ) {
			degree = 3.14 - degree;
		}
	}

	// ���ڼ���
	void launchFrme() {
		setSize(1209, 611); // ����width��height
		setLocation(53, 53); // ��������
		setVisible(true);

		// �ػ����ڣ�ÿ�뻭25��
		while (true) {
			repaint();
			try {
				Thread.sleep(40); // 40ms
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// main
	public static void main(String[] args) {
		System.out.println("ball game2 main");

		BallGame2 game = new BallGame2();
		game.launchFrme();

	}

}
