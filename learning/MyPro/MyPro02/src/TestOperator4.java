/**
 * test λ�����
 * @author china
 *
 */
public class TestOperator4 {
	public static void main(String[] args) {
		int a = 3; // 0 0 1 1
		int b = 4; // 0 1 0 0
		
		System.out.println(a & b); // ��λ��, 0 0 0 0
		System.out.println(a | b); // ��λ��0 1 1 1
		System.out.println(a ^ b); // ��λ���, 0 1 1 1 
		System.out.println(~a);
		
		// ��λ����
		System.out.println("��λ���㣺");
		System.out.println(a<<1);
		System.out.println(a<<2);
		System.out.println(a>>2);
	}
}
