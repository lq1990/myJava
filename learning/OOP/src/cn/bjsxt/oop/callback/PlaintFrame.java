package cn.bjsxt.oop.callback;


public class PlaintFrame {
	public static void drawFrame(IMyFrame f) {
		System.out.println("�����߳�");
		System.out.println("����ѭ��");
		System.out.println("�鿴��Ϣջ");
		
		// �����ڣ��˴�Ϊһ�� Callback��� Hook�������ⲿ���� ʵ�ֲ�ͬ�Ĺ���
		f.paint();
		
		System.out.println("���ӻ��棬���Ч��");
		
		
		/*
		 * ���ϵĲ��裬ģ�巽��ģʽ���й̶��Ĳ��֣�Ҳ�����ɱ��
		 */
	}
	
	
	
	public static void main(String[] args) {
		drawFrame(new GameFrame02());
	}
}


class GameFrame01 /*extends MyFrame */ implements IMyFrame {
	public void paint() {
		System.out.println("GameFrame01.paint()");
		System.out.println("������");
	} 
}

class GameFrame02 implements IMyFrame {
	public void paint() {
		System.out.print("GameFrame02.paint()");
		System.out.println(" ������");
	} 
}