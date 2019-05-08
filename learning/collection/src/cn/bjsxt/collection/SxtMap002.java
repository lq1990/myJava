package cn.bjsxt.collection;

/**
 * �Զ���Map ������ 1. ���Ч��
 * 
 * @author china
 *
 */
public class SxtMap002 {
	SxtLinkedList[] arr = new SxtLinkedList[999]; // �����д洢 ����

	int size;

	public void put(Object key, Object value) {
//		System.out.println(key.hashCode()); // ����key�ĵ�ַ ����hashCode

		SxtEntry e = new SxtEntry(key, value);
		int code = key.hashCode() % arr.length;

		if (arr[code] == null) {
			arr[code] = new SxtLinkedList();
			arr[code].add(e);

		} else {
			// ����Ƿ�����key
			for (int i = 0; i < arr[code].size(); i++) {
				// ȡarr��codeλ�ô�����ĵ�iλ�õ�obj
				SxtEntry eGet = (SxtEntry) arr[code].get(i);

				if (eGet.key.equals(key)) {
					eGet.value = value;
					return;
				}
			}
			
			// ��ʱ��keyû�ظ�
			arr[code].add(e);

		}

		size++;

	}

	public Object get(Object k) {
		int code = k.hashCode() % arr.length;

		if (arr[code] != null) {
			// ��ʱcode����������һ������Ԫ��
			for (int i = 0; i < arr[code].size(); i++) {
				SxtEntry eGet = (SxtEntry) arr[code].get(i);
				if (eGet.key.equals(k)) {
					return eGet.value;
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {

		SxtMap002 mp = new SxtMap002();
		mp.put("abc", 123);
		mp.put("jkjk", 444);
		mp.put("eee", 555);
//		mp.put("eee", 777);
		System.out.println(mp.get("eee"));

//		String s = "abc";
//		String s2 = "aabc";
//		System.out.println(s.hashCode());
//		System.out.println(s2.hashCode());

	}

}
