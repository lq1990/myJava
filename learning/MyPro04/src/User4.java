
/**
 * test ������ֵ����
 * @author china
 *
 */
public class User4 {
	int id;
	String name;
	String pwd;
	
	public User4(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public void testParamTransfer(User4 u) {
		u.name = "anna";
	}
	
	public void testParamTransfer2(User4 u) {
		// u1 ����ֵ���ݣ���ַ������u
		u = new User4(200, "lq"); // �����¶��󣬵�ַ�仯�ˡ���ԭu1���ݲ�Ӱ�졣
		// ���е��˴�ʱ��u��ָ���ַ�����ٺ� u1һ����u�ĸı䲻Ӱ��u1
		
	}
	
	
	public static void main(String[] args) {
		User4 u1 = new User4(100, "beta");
		System.out.println(u1.name);
		u1.testParamTransfer(u1); 
		// ��̬�����д���ֵ��һ��������Ȼ��ֵ���ݣ��ʴ����� ����ĵ�ַ
		System.out.println(u1.name);
		
		u1.testParamTransfer2(u1); 
		// u1��ַ������fn�У���Ȼfn��u��ַ�ı䣬��u1��ַ���䣬���u1.name ����
		System.out.println(u1.name);
	}
	
}
