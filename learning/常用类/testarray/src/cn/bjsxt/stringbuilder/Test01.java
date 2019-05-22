package cn.bjsxt.stringbuilder;

/**
 * String ���ɱ��ַ�����. 
 * StringBuilder �ǿɱ��ַ����У��̲߳���ȫ Ч�ʸ�.
 *  StringBuffer ��StringBuilder���ƣ��̰߳�ȫ ��Ч�ʵͣ�
 *  
 *  ��̬��������ݡ�ʵ�����ǽ��� һ����������飬��ԭ���ݿ���������
 * 
 * @author china
 *
 */
public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); // Ĭ�ϵ� �ַ����鳤�� 16

		StringBuilder sb1 = new StringBuilder(32); // ���� �ַ����鳤��Ϊ32
		StringBuilder sb2 = new StringBuilder("abcd");
		sb2.append("efg");
		sb2.append(true).append(false).append('z');
		System.out.println(sb2);

		System.out.println("############");
		StringBuilder gh = new StringBuilder("a");
		for (int i = 0; i < 20; i++) {
			gh.append(i);
		}
		System.out.println(gh);

	}
}
