package cn.bjsxt.oop.testInterface;

public interface Flyable {
	int MAX_SPEED = 11000;
	int MIN_HEIGHT = 1;
	void fly();
}

interface Attack {
	void attack();
}

class Plane implements Flyable {

	@Override
	public void fly() {
		System.out.println("�ɻ���");
	}
}

class Man implements Flyable {

	@Override
	public void fly() {
		System.out.println("��������");
	}
	
}

class Stone implements Flyable, Attack {
	int weight;
	
	@Override
	public void fly() {
		System.out.println("���ӳ�ȥ��");
	}

	@Override
	public void attack() {
		System.out.println("ʯͷ����");
	}
	
}


