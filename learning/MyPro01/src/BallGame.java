
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {

	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

	double x = 100; // С��ĺ�����
	double y = 100; // С���������
	boolean right = true; // ����

	// �����ڵķ�����ע������img�����أ�������ʾ������С��������󻯼�����ʾimg�ˡ�
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ�Σ�");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int) x, (int) y, null);

		if (right) {
			x = x + 20;
		} else {
			x = x - 20;
		}
		
		if(x>= (1209-53-35)) { // ��Ϊͼ�������Ͻ�Ϊԭ�㶨λ�����ȥ���35
			right = false;
		}
		if (x <= 53) {
			right = true;
		}

	}

	// ���ڼ���
	void launchFrme() {
		setSize(1209, 611); // ����width��height
		setLocation(50, 50); // ��������
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
		System.out.println("ball game main");

		BallGame game = new BallGame();
		game.launchFrme();

	}

}
