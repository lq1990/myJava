package cn.sxt.oo2;

public class TestSuper02 {
	public static void main(String[] args) {
		System.out.println("create a ChildClass obj");
		new ChildClass2();
	}
}

class FatherClass2 {
	public FatherClass2() {
		super();
		System.out.println("create FatherClass");
	}
}

class ChildClass2 extends FatherClass2 {
	public ChildClass2() {
		super(); // ��ʹ��Ϊ��д��ҲĬ���С�
		System.out.println("create ChildClass");
	}
}

// �̳���׷�ݣ�Child -> Father -> Object��
// �ڹ���Childʱ�����ȵ���Object��ʼ������Father���� Child
