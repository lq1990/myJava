package com.wendao.io;

/**
 * ģ��coffee
 * 1. �����������Ҫװ�εĳ�����󣬽ӿڻ������
 * 2. �����������Ҫװ�εĶ���
 * 3. ����װ���ࣺ�����˶Գ�����������ã��Լ�װ���Ź��еķ���
 * 4. ����װ���ࣺ��װ�εĶ���
 * @author china
 *
 */
public class Decorate2 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink sugar = new Sugar(coffee);
//		System.out.println("price: "+sugar.cost()+", info: "+sugar.info());
//		Drink milk = new Milk(coffee);
//		System.out.println("price: "+milk.cost()+", info: "+milk.info());
		
		Drink milksugar = new Milk(sugar);
		System.out.println("price: "+milksugar.cost()+", info: "+milksugar.info());
		
	}
}

// �������
interface Drink{
	double cost();
	String info();
}

// �������
class Coffee implements Drink {

	private String name = "ԭζ����";
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
}

// ����װ����
abstract class Decorate implements Drink {
	
	private Drink drink;
	
	public Decorate(Drink drink) {
		this.drink = drink;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}

// ����װ����
class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
//		System.out.println("milk: "+super.cost()+20);
		return super.cost()+20;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+" add milk";
	}
}

class Sugar extends Decorate {
	
	public Sugar(Drink drink) {
		super(drink);
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		System.out.println("sugar: "+super.cost()+10);
		return super.cost()+10;
	}
	
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+" add sugar";
	}
}


