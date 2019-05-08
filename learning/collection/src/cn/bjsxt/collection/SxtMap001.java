package cn.bjsxt.collection;

import java.util.Arrays;

/**
 * self def Map
 * key�����ظ���
 * ��ǰ���⣺getʱ��Ҫ��������
 * @author china
 *
 */
public class SxtMap001 {
	SxtEntry[] arr = new SxtEntry[100];

	int size;

	public void put(Object key, Object value) {
		SxtEntry e = new SxtEntry(key, value);

		// �����ֵ�ظ���valueֱ�Ӹ���
		for (int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)) {
				arr[i].value = value;
				return;
			}
		}

		arr[size++] = e;
	}

	/**
	 * get corresponding value of key
	 * 
	 * @param k
	 * @return
	 */
	public Object get(Object k) {
		for (SxtEntry item : arr) {
			if (k.equals(item.key)) { // equals
				return item.value;
			}
		}
		return null;
	}

	public boolean containsKey(Object k) {
		for (int i = 0; i < size; i++) {
			if (arr[i].key.equals(k)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsValue(Object v) {
		for (int i = 0; i < size; i++) {
			if (arr[i].value.equals(v)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SxtMap001 m = new SxtMap001();
		m.put("abc", 123);
		m.put("ddd", 434);
		m.put("ddd", 997);

		System.out.println(m);
		System.out.println(m.get("ddd"));

		System.out.println(m.containsKey("abc"));
		
		System.out.println("###########");
		int num = 16; // ���鳤��Ϊ 2��������
		System.out.println(17 & (num-1)); // ʹ�� λ���㣬ʵ��ȡ��
		
		System.out.println("##############");
		System.out.println(4 >> 2);
		
		System.out.println("###########");
		System.out.println(new SxtEntry("aaa", 111).hashCode());
		System.out.println(new SxtEntry("aaa", 111).hashCode());
	}

}

class SxtEntry {
	Object key;
	Object value;

	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}
