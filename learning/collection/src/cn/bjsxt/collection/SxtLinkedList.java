package cn.bjsxt.collection;

/**
 * 
 * @author china
 *
 */
public class SxtLinkedList {
	private Node first; // ˫������ֻҪ����� ͷ��β���Ϳ����ҵ���������
	private Node last; // ˫�������β

	private int size = 0;

	public void add(Object obj) {
		Node n = new Node();

		if (first == null) {
			n.prev = null;
			n.obj = obj;
			n.next = null;

			first = n;
			last = n;
		} else {
			// ֱ����last�ڵ�������µĽڵ�
			n.prev = last; // last <- n
			n.obj = obj;
			n.next = null;

			last.next = n; // ��Ϊ��˫������last -> n
			last = n;
		}

		size++;
	}

	public int size() {
		return size;
	}

	public Object get(int index) {
		// Խ�紦��
		rangeCheck(index);

		Node temp = node(index);
		if (temp != null) {
			return temp.obj;
		}
		return null;
	}

	public void remove(int index) {
		rangeCheck(index);

		Node temp = node(index);

		// ��ʱ��temp Ϊindex��
		if (temp != null) {
			if (index == 0) {
				first = temp.next;
				first.prev = null;
			} else if (index == size - 1) {
				last = temp.prev;
				last.next = null;
			} else {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp = null; // let gc do its work
//				Node up = temp.prev;
//				Node down = temp.next;
//				up.next = down;
//				down.prev = up;
			}

			size--;
		}

	}

	public void add(int index, Object obj) {
		rangeCheck(index);

		Node objNode = new Node(null, obj, null);

		Node temp = node(index);
		if (index != 0) {
			temp.prev.next = objNode;
			temp.prev = objNode;

			objNode.prev = temp.prev;
			objNode.next = temp;
		} else {
			temp.prev = objNode;
			first = objNode;
			// ��first���ͷ�� ��objNode�����ǵ�node�д�first��ʼ����������first������ʱ����

			objNode.prev = null;
			objNode.next = temp;

			System.out.println("first.obj: " + first.obj);
		}
		size++;

	}

	/**
	 * get the element of index
	 * 
	 * @param index
	 * @return
	 */
	public Node node(int index) {
		Node temp = null;
		if (first != null) { // ��first��ʼ��
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		}

		return temp;
	}

	public void rangeCheck(int index) {
		if (index > size - 1 || index < 0) {
			try {
				throw new IndexOutOfBoundsException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void showLinkedList(SxtLinkedList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		SxtLinkedList list = new SxtLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		System.out.println(list.size());

		showLinkedList(list);
		System.out.println("##########");
		list.remove(1);
		System.out.println(list.size());
		showLinkedList(list);
		System.out.println("##########");
		list.add(0, "jjj");
		showLinkedList(list);

	}

}
