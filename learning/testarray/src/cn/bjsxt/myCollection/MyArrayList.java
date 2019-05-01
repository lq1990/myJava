package cn.bjsxt.myCollection;

/**
 * ģ��ʵ�� JDK���ṩ�� ArrayList��
 * 
 * @author china
 *
 */
public class MyArrayList {

	private Object[] value;

	private int size;

	public MyArrayList() {
//		value = new Object[16];
		this(10); // ʹ��this������һ�� ������

	}

	public MyArrayList(int size) {
		if (size < 0) {
			try {
				throw new Exception(); // �ֶ��׳��쳣
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		value = new Object[size];
	}

	public void add(Object obj) {
		value[size] = obj;
		size++;
		if (size >= value.length) {
			// װ�����ˣ���Ҫ����
			int newCapacity = value.length * 2;
			Object[] newList = new Object[newCapacity];

			for (int i = 0; i < value.length; i++) {
				newList[i] = value[i];
			}

			value = newList; // ���µ��������� value
		}

	}

	public Object get(int index) {
		rangeCheck(index);

		return value[index];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int indexOf(Object obj) {
		if (obj==null) {
			return -1;
		}else {
			for(int i=0;i<value.length;i++) {
				if (obj==value[i]) {
					return i;
				}
			}
			return -1;
		}
	}
	
	public int lastIndexOf(Object obj) {
		if (obj==null) {
			return -1;
		}else {
			for(int i=value.length-1; i >= 0; i--) {
				if (obj==value[i]) {
					return i;
				}
			}
			return -1;
		}
	}
	
	/**
	 * set: value[index] = obj
	 * @param index
	 * @param obj
	 * @return ԭ�е�value[index]
	 */
	public Object set(int index, Object obj) {
		rangeCheck(index);
		
		Object oldObj = value[index];
		value[index] = obj;
		return oldObj;
	}
	
	public void rangeCheck(int index) {
		if (index < 0 || index > size - 1) {
			try {
				throw new Exception(); // �ֶ��׳��쳣
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("aaa");
		list.add(new Human("anna"));
		list.add("bbb");
		list.add("bbb");
		list.add("bbb");

		Human h = (Human) list.get(1);
		System.out.println(h.getName());

//		System.out.println(list.get(1));
		System.out.println(list.size());
	}

}
