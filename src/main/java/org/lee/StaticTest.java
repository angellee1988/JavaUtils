package org.lee;

class Father {
	public static int m = 33;
	static {
		System.out.println("父类被初始化");
	}
}

class Child extends Father {
	static {
		System.out.println("子类被初始化");
	}
}

public class StaticTest {
	public static void main(String[] args) {
//		System.out.println(Child.m);
		System.out.println(new Child());
	}
}