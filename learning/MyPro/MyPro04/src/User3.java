
/**
 * test ��̬��ʼ�����ʹ��
 * @author china
 *
 */
public class User3 {
	int id;
	String name;
	String pwd;
	static String company;
	
	// ����ĳ�ʼ��ʱ ִ��
	static {
		System.out.println("ִ����ĳ�ʼ������");
		company = "wendao";
		printCompany();
		
	}
	
	public static void printCompany() {
		System.out.println(company);
	}
	
	public static void main(String[] args) {
		User3 u = null;
	}
}
