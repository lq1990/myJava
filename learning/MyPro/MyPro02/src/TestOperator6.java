/**
 * 
 * @author china
 *
 */
public class TestOperator6 {
	public static void main(String[] args) {
		int score = 80;
		String type = score<60 ? "������" : "����";
		System.out.println(type);
		
		
		System.out.println(true & true);
		System.out.println(true & false);
		System.out.println(false & true);
		System.out.println(false & false);
		
		System.out.println(false && 1<1/0); // && Ϊ��·������Ϊ�߼��� ʹ��
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println(true | true);
		System.out.println(false | false);
		System.out.println(true | false);
		System.out.println(false | true);
		
		System.out.println(true || true); // || ��·�򣬿���Ϊ�߼��� ʹ��
		System.out.println(false || false);
		System.out.println(true || false);
		System.out.println(false || true);
	}
}
