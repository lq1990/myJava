/**
 * test �߼������ & | ! ^����·���� && ||
 * 
 * @author china
 *
 */
public class TestOperator3 {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;

		System.out.println(b1 & b2);
		System.out.println(b1 | b2);
		System.out.println(b1 ^ b2); // ���
		System.out.println(!b2);
		
		// ��·���� && ||
		// int c = 3/0;
		boolean b3 = 1 > 2 && 2<(3/0);
		System.out.println(b3);
	}
}
