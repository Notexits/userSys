package com.lingnan.usersys.common.util;

import java.util.Scanner;

import com.lingnan.usersys.common.exception.NumberChooseException;

public class CommonUtils {
	public static int getNumber(int begin, int end) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int choose = -1;
		while(true) {
			try {
				System.out.print("请选择：");
				choose = scanner.nextInt();
				
				if(choose >= begin && choose <= end) {
					break;
				}else {
					throw new NumberChooseException();
				}
			}catch(NumberChooseException e){
				System.out.println("请选择正确的选项!\n");
				choose = -1;
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("请输入一个数字!\n");
				choose = -1;
				scanner.nextLine();
			}
		}
		
		return choose;
	}
}
