package cn.bjsxt.oop.polymorphism.myServlet;

public class HttpServlet {
	public void service() {
		System.out.println("HttpServlet.service()");
		this.doGet(); // this ָ������ new������ �������
	}
	
	public void doGet() {
		System.out.println("HttpServlet.doGet()");
		
	}
	
}
