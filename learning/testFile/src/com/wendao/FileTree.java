package com.wendao;

import java.io.File;

/**
 * ��ӡĿ¼��״�ṹ��ʹ�õݹ��㷨
 * @author china
 *
 */
public class FileTree {
	public static void main(String[] args) {
		File f = new File("D:\\myGithub\\myJava\\learning\\testFile");
		printFile(f, 0);
	}
	
	static void printFile(File file, int level) {
		for(int i=0;i<level;i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File tmp : files) {
				printFile(tmp, level+1);
			}
		} 
		
	}
}
