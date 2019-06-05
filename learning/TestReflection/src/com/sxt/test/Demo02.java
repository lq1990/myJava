package com.sxt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * 	Ӧ�÷����API����ȡ�����Ϣ(������֣����ԣ�������������)
 * 
 * @author china
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "com.sxt.test.bean.User";
		try {
			Class clz = Class.forName(path);
			
			// ��ȡ�������
			System.out.println(clz.getName()); // ���� ����+����
			System.out.println(clz.getSimpleName()); // ������� User
			
			// ���������Ϣ
			Field[] fs = clz.getFields(); // ֻ�ܻ��public������
			Field[] fs2 = clz.getDeclaredFields(); // �����������
			System.out.println(fs.length);
			System.out.println(fs2.length);
			
			for (Field field : fs2) {
				System.out.println(field);
			}
			
			System.out.println();
			// ��÷�����Ϣ
			Method[] methods = clz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method);
			}
			
			System.out.println();
			
			// ��ù�������Ϣ
			Constructor[] cts = clz.getDeclaredConstructors();
			for (Constructor constructor : cts) {
				System.out.println("��������"+constructor);
			}
			// ���ָ���Ĺ����� 
			Constructor ct1 = clz.getDeclaredConstructor(int.class, int.class, String.class);
			System.out.println(ct1);
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}














