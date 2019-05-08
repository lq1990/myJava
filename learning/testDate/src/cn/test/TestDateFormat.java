package cn.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat ��� �ַ�����ʱ����� ��ת��
 * @author china
 *
 */
public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss, "
				+ "�����w��, ���µ�W��"); // �趨��ʽ
		
		Date d = new Date(12321314323L);
		String s = df.format(d);
		System.out.println(s);
		
		System.out.println("##############");
		String s2 = "1977-7-7";
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); // �趨��ʽ
		try {
			Date d2 = df2.parse(s2);
			System.out.println(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
