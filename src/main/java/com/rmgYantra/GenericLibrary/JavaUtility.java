package com.rmgYantra.GenericLibrary;

import java.util.Random;

public class JavaUtility {

	public static int getRandomNumber() {
		Random random=new Random();
		int rNo=random.nextInt(1000);
		
		return rNo;
	}
}
