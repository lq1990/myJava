package cn.bjsxt.collection;

/**
 * self def Map
 * 
 * @author china
 *
 */
public class SxtHashMap01 {

	Node2[] table; // λͰ���飬bucket array
	int size; // ��ŵļ�ֵ�Եĸ���

	public SxtHashMap01() {
		table = new Node2[16]; // ����һ�㶨��Ϊ2����������

	}

	public void put(Object key, Object value) {
		Node2 newNode = new Node2();
		newNode.hash = myHash(key.hashCode(), table.length); // hash value
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;

		Node2 temp = table[newNode.hash];
		Node2 iterLast = null; // ���ڱ��������һ��Ԫ��
		boolean keyRepeat = false;
		
		if (temp == null) {
			// �˴�����Ԫ��Ϊ�գ���ֱ�ӽ��½ڵ�Ž�ȥ
			table[newNode.hash] = newNode;
		} else {
			// ��������
			while (temp != null) {
				if (temp.key.equals(key)) {
					keyRepeat = true;
					// ��key�ظ����򸲸�
					temp.value = value;
					break;
				} else {
					// key���ظ�
					iterLast = temp;
					temp = temp.next;
					
				}
			}
			
			if (!keyRepeat) {
				iterLast.next = newNode;
			}
			
			
		}
	}

	public int myHash(int v, int length) {
		System.out.println("hash in myHash &: " + (v & (length - 1)));
		System.out.println("hash in myHash %: " + (v % length));
		return v & (length - 1);
	}

	public static void main(String[] args) {
		SxtHashMap01 m = new SxtHashMap01();
		m.put(10, "aaa");
		m.put(20, "bb");
		m.put(30, "cccc");
		m.put(10, "abc");
		m.put(26, "awd");

		System.out.println(m);
	}
}
