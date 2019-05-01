package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {
	double x, y;
	
	static Image[] imgs = new Image[6]; 
	// static ������ֻ��ʼ��һ�Ρ����ж������Ҫ��ըʱ�����ض��new
	static {
		for(int i=0;i<6;i++) {
			imgs[i] = GameUtil.getImage("images/explode/e0"+(i+1)+".png");
			imgs[i].getWidth(null);
		}
	}
	
	int count;
	
	public void draw(Graphics g) {
		if(count <=5) {
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
