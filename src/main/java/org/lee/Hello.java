package org.lee;

class Hello implements Runnable {
	public void run() {
		System.out.println("执行run方法");
		try {
			Thread.sleep(10000);
			System.out.println("线程完成休眠");
		} catch (Exception e) {
			System.out.println("休眠被打断");
			return; // 返回到程序的调用处
		}
		System.out.println("线程正常终止");
	}

	public static void main(String[] args) {
		Hello he = new Hello();
		Thread demo = new Thread(he, "线程");
		demo.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		demo.interrupt(); // 2s后中断线程
	}
}