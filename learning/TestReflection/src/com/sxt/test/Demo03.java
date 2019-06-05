package com.sxt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.sxt.test.bean.User;

/**
 * 
 * 	ͨ������API��̬�Ĳ�������������������������
 * 
 * @author china
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		// ��̬����������
		String path = "com.sxt.test.bean.User";
		
		try {
			Class<User> clz = (Class<User>) Class.forName(path);
			
			// ͨ������API��̬���ù��췽�����������
			User u = clz.newInstance(); // ������User���޲ι��췽��
			System.out.println(u);
			
			Constructor<User> c = clz.getDeclaredConstructor(int.class, int.class, String.class);
			User u2 = c.newInstance(1001, 18, "anna");
			
			System.out.println(c);
			System.out.println(u2.getId());
			
			// ͨ������API������ͨ������ͨ�����俴�����鷳������method��Ҳ��String�����Զ�̬����
			User u3 = clz.newInstance();
			u3.setUname("beta"); // ���淽��
			System.out.println(u3.getUname());
			Method method = clz.getDeclaredMethod("setUname", String.class); // ͨ������
			method.invoke(u3, "cello");
			System.out.println(u3.getUname()); 
			
			// ͨ������API��������
			User u4 = clz.newInstance();
			Field f = clz.getDeclaredField("uname");
			f.setAccessible(true); // ��Ϊf����Ϊprivate����Ҫ����
			f.set(u4, "delta");
			System.out.println(u4.getUname());
			System.out.println(f.get(u4));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
