package cn.bjsxt.stringbuilder;

/**
 * ����StringBuilder �ĳ��÷���
 */
public class TestStringBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
		sb.delete(3, 5); // [3,5) => abcfghijklmnopqrstuvwxyz
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.indexOf("z"));
		
		
		StringBuffer sb2 = new StringBuffer();
		
		String a;
		
	}
}
