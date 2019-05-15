package cn.sxt.oo2;

/**
 * 
 * @author china
 *
 */
public class TestPolymorphism {
	public static void main(String[] args) {
		Animal a = null;
		a = new Animal();
		System.out.println(a);
		animalCry(a);
		
		Animal d = new Dog(); // �Զ�����ת��
		System.out.println(d);
		animalCry(d);
		
		Animal c = new Cat();
		
		Dog d2 = (Dog) d; // ǿ������ת��
		d2.door();
		
		Dog d3 = (Dog) c;
		d3.door();
		
		String s;
	}
	
	static void animalCry(Animal a) {
		a.shout();
	}
}

class Animal {
	
	public void shout() {
		System.out.println("����һ��");
	}
}

class Dog extends Animal {
	public void shout() {
		System.out.println("������");
	}
	
	public void door() {
		System.out.println("����");
	}
}

class Cat extends Animal {

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	
}
