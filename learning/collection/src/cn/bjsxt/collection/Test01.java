package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author china
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		// ArrayList: �ײ��� ����ʵ�֣���ѯ�죬������ɾ�������̲߳���ȫ��
		// LinkedList���ײ���������ѯ����������ɾ���졣�̲߳���ȫ��
		// Vector���ײ������飬�̰߳�ȫ�ģ���Ч�ʵ͡�
		
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list);
		
//		list.remove("aaa");
//		System.out.println(list.size());
//		
		List list2 = new ArrayList();
		list2.add("bb");
		list2.add("ccc");
		
		list.add(list2);
		System.out.println(list);
		System.out.println(list.size());
		
		System.out.println("###############");
		// ��˳��Ĳ���
		String a = (String) list.get(0);
		System.out.println(a);
		
		list.set(1, "1jasjkdgj");
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
	}
}

class Dog {
	
}