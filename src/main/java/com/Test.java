package com;

import com.udpwork.ssdb.Link;


/**
 * SSDB Java client SDK demo.
 */
public class Test {
	public static void main(String[] args) throws Exception {
		String s = "3\r\nget\n1\r\nk\r\n\r\n";
		s += s;
		s += s;
		byte[] bytes = s.getBytes();
		Link link = new Link();
		link.testRead(bytes);
		for(int i=0; i<bytes.length; i++){
			byte[] bs = {bytes[i]};
			link.testRead(bs);
		}
		
		
		Integer a = 20000001 ;
		Integer b = 20000001 ;
		System.out.println(a.intValue()==b);
		
		
		System.out.println(String.format("该车商为天天车商贷授信用户,目前可用额度:%.2f元,车辆成交价%f元可建议车商在签订完合同后申请使用车商贷支付车款", 2000f,300f)) ;
		
		
		String f = "100.33" ;
		
		Float aaaa = Float.parseFloat(f) ;
		System.out.println(aaaa);
		
	}
	
}
