package cn.bjsxt.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * test use of TreeMap
 * 
 * @author china
 *
 */
public class TestTreeMap {

	public static void main(String[] args) {
		Map<Integer, String> mp = new TreeMap<Integer, String>();
		mp.put(20, "aa");
		mp.put(3, "bb");
		mp.put(6, "cc");

		for (Integer k : mp.keySet()) {
			System.out.println(k + " --- " + mp.get(k));
		}

		System.out.println("#############");
		
		Map<Emp, String> mp2 = new TreeMap<Emp, String>();
		mp2.put(new Emp(100, "zhangsan", 50000), "zhangsan good boy");
		mp2.put(new Emp(200, "lisi", 5000), "lisi good boy");
		mp2.put(new Emp(150, "wangwu", 6000), "wangwu good boy");
		mp2.put(new Emp(111, "anna", 6000), "anna good boy");
		
		for (Emp k : mp2.keySet()) {
			System.out.println(k + " --- " + mp2.get(k));
			// �Ȱ��� salary ��С��������
		}
	}
}
 
class Emp implements Comparable<Emp> {
	int id;
	String name;
	double salary;
	
	@Override
	public String toString() {
		return "id: "+id+", name: "+name+", salary: "+salary;
	}

	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int compareTo(Emp o) {
		// ������С�ڣ�0�����ڣ�����������
		
		if (this.salary > o.salary) {
			return 1;
		} else if (this.salary < o.salary) {
			return -1;
		} else {
			// �Ȱ��� salary�����ٰ���id����
			if (this.id > o.id) {
				return 1;
			}else if(this.id < o.id){
				return -1;
			} else {
				return 0;
			}
		}
	}

}
