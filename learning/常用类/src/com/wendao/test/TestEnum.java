package com.wendao.test;

/**
 * test Enum
 * @author china
 *
 */
public class TestEnum {
	public static void main(String[] args) {
//		System.out.println(Season.SPRING);
		
		Season a = Season.AUTUMN;
		
		switch (a) {
		case SPRING:
			System.out.println("spring is coming");
			break;
		case SUMMER:
			System.out.println("summer is comint");
			break;
		case AUTUMN:
			System.out.println("autumn is coming");
			break;
		case WINTER:
			System.out.println("winter is coming");
			break;
		default:
			break;
		}
	}
}

enum Season {
	SPRING, SUMMER, AUTUMN, WINTER
}

enum Week {
	����һ, ���ڶ�, ������, ������, ������, ������, ������
}
