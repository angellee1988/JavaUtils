package com;

public class TestTry {

	public static void main(String[] args) {
		System.out.println(new TestTry().func()); ;
	}

	public int func() {
		try {
			int i=3;
			return i;
		} catch (Exception e) {
			return 1;
		} finally {
			return 1;
		}
	}
}
