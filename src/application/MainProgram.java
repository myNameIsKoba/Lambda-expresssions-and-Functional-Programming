package application;

import application.testComparator.TestClass;
import moreTests.OtherTests;

public class MainProgram {

	public static void main(String[] args) {
		TestClass.test1();
		System.out.println("--------------------------------");
		
		OtherTests.test1();	System.out.println("--------------------------------");
		OtherTests.test2();	System.out.println("--------------------------------");
		OtherTests.test3();	System.out.println("--------------------------------");
		OtherTests.test4();	System.out.println("--------------------------------");
		OtherTests.test5();	System.out.println("--------------------------------");
		OtherTests.test6();	System.out.println("--------------------------------");
		OtherTests.test7();	System.out.println("--------------------------------");
		OtherTests.test8();	System.out.println("--------------------------------");
		
	}
}
