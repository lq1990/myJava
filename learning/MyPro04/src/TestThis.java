/**
 * 
 * @author china
 *
 */
public class TestThis {

	int a, b, c;
	TestThis(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	TestThis(int a, int b, int c){
		this(a, b); // ָ�� ����һ��������
		this.c = c;
	}
	
	void sing() {
		
	}
	
	void eat() {
		this.sing();
		System.out.println("�Է�");
	}
	
	public static void main(String[] args) {
		TestThis hi = new TestThis(2, 3);
		hi.eat();
		
		
	}
}
