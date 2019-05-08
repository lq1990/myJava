package cn.bjsxt.collection;

/**
 * toString() override
 * 
 * @author china
 *
 */
public class SxtHashMap2 {

	Node2[] table; // λͰ���飬bucket array
	int size; // ��ŵļ�ֵ�Եĸ���

	public SxtHashMap2() {
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
//		System.out.println("hash in myHash &: " + (v & (length - 1)));
//		System.out.println("hash in myHash %: " + (v % length));
		return v & (length - 1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{ ");

		for (int i = 0; i < table.length; i++) {
			Node2 temp = table[i];
			
			while (temp!=null) {
				sb.append(temp.key+":"+temp.value+", ");
				
				temp = temp.next;
			}
		}
		
		sb.delete(sb.length()-2, sb.length()-1);
		sb.append("}");
		return sb.toString();
	}

	public static void main(String[] args) {
		SxtHashMap2 m = new SxtHashMap2();
		m.put(10, "aaa");
		m.put(20, "bb");
		m.put(30, "cccc");
		m.put(10, "abc");
		m.put(26, "awd");

		System.out.println(m);
		
		System.out.println("###########");
		StringBuilder str  = new StringBuilder("abcde");
		System.out.println(str.delete(4, 5)); // delete [)
		
	}
}
