/**
 * 
 * @author china
 *
 */
public class TestMethod {
	public static void main(String[] args) {
		// ͨ�����������ͨ����
		TestMethod tm = new TestMethod();
		tm.printSxt();
		tm.printSxt();
		tm.printSxt();
		int c = tm.add(1, 2, 3) + 1000;
		System.out.println(c);
	}
	
	// ����� ��ͨ����
	void printSxt() {
		System.out.println("����������");
	}
	
	int add(int a, int b, int c) {
		int sum = a+b+c;
		System.out.println(sum);
		return sum; // return ��������������У�������ֵ
	}
}
