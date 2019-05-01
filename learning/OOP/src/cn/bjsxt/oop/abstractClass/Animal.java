package cn.bjsxt.oop.abstractClass;

public abstract class Animal {
	String str;
	public abstract void run();
	public void breath() {
		System.out.println("����");
		this.run();
	}
	
	public Animal() {
		
	}
	
}

class Cat extends Animal {
	
	@Override
	public void run() {
		System.out.println("è��С��");
	}
	
}

class Dog extends Animal {

	@Override
	public void run() {
		System.out.println("����");
	}
	
}
