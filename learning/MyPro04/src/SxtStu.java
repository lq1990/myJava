
// һ�� .java�ļ��ڿ��ж��class�������ֻ����һ�� public class
public class SxtStu {

	// ���� fields����ֻ������û�з��� ��Ϊ�ṹ��
	int id;
	String name;
	int age;

	Computer comp;

	// methods
	void study() {
		System.out.println("study..., using " + comp.brand);
	}

	void play() {
		System.out.println("play...");
	}

	// �޲εĹ��췽������Ĭ�����ɡ�����Ϊ��д��
	public SxtStu() {
		// TODO Auto-generated constructor stub

	}

	// main
	public static void main(String[] args) {
		SxtStu stu = new SxtStu();
		System.out.println(stu);
		
		stu.id = 1001;
		stu.name = "lq";
		stu.age = 22;
		
		Computer c1 = new Computer();
		System.out.println(c1);
		c1.brand = "lenovo";
		
		stu.comp = c1;
		
		stu.play();
		stu.study();
		
	}

}

class Computer {
	String brand;
}
