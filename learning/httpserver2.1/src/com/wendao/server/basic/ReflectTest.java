package com.wendao.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * Reflection:
 * 1. get Class
 * 
 * 2. ���ʣ�
 * ��̬����
 * @author china
 *
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// ���ַ�ʽ
		// 1. obj.getClass()
		Class clz = new Iphone().getClass();
		System.out.println(clz);
		// 2. Cla.class()
		clz = Iphone.class;
		System.out.println(clz);
		// 3. Class.forName("pkg.ClassName") ����
		clz = Class.forName("com.wendao.server.basic.Iphone");
		System.out.println(clz);
		
		// create obj
//		Iphone iphone2 = (Iphone) clz.newInstance();
//		System.out.println(iphone2);
		
		// jdk9 �н���
		Iphone iphone2 = (Iphone) clz.getConstructor().newInstance();
		System.out.println(iphone2);
		
	}
}

class Iphone{
	public Iphone() {
	}
}