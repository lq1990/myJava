package cn.bjsxt.collection;

public class Node {
	Node prev;
	Object obj; // ���ڵ�洢�����ݣ�ֻ�������client���Բ������õġ�
	Node next;
	
	public Node() {
		
	}
	
	public Node(Node prev, Object obj, Node next) {
		super();
		this.prev = prev;
		this.obj = obj;
		this.next = next;
	}
	
	
}
