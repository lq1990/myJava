/**
 * test var
 * 
 * @author china
 *
 */
public class TestVariable {
	static int size; // ��̬������������ ��
	
	boolean a; // ��Ա����, �����ڶ���
	
	public static void main(String[] args) {
		{
			int age; // local var������������
		}
		int salary = 3000; // local var �����ڷ���
		
		int gao = 10;
		System.out.println(gao);
		
		TestVariable tv = new TestVariable();
		System.out.println(tv.a);
	}
}
