package org.lee;

import exception.ZeroException;


public class TestException {

	public static void main(String[] args) {
		new TestException().test();
	}
	
	public void test(){
		try {
			zero() ;
		} catch (ZeroException e1) {
			e1.printStackTrace();
		}catch(Exception ee){
			System.out.println("Exception被执行了");
		}
	}
	
	public void zero() throws ZeroException{
		throw new ZeroException("500","除数为0") ;
	}
}
