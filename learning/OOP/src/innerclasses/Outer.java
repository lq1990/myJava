package innerclasses;

public class Outer {
	public static void main(String[] args) {
		Face f = new Face();
		
		Face.Nose n = f.new Nose(); // �Ǿ�̬�ڲ����new
		n.breath();
		
		Face.Ear e = new Face.Ear(); // ��̬�ڲ���� new
		e.listen();
	}
}



class Face {
	int type;
	String shape = "������";
	static String color = "����";
	
	
	/**
	 *  �ڲ�������� �ⲿ������ڲ��಻��ʹ��static
	 * @author china
	 *
	 */
	class Nose {
		String type;
		void breath() {
			System.out.println(shape);
			System.out.println(Face.this.type);
			System.out.println("����");
		}
	}
	
	static class Ear {
		void listen() { 
			System.out.println(color); // ��̬�ڲ��� ���Է����ⲿ��ľ�̬����
			System.out.println("������");
		}
	}
}
