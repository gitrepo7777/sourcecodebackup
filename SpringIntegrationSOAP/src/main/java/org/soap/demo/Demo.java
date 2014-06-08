package org.soap.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Anand
 * @email  anandindnr@gmail.com
 * 
 * Just to demonstrate the usage of Spring Message Gateway and Interaction with Message Queue
 */

public class Demo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("context.xml", Demo.class);
		
		SampleGateway s = cc.getBean("gateway1", SampleGateway.class);
		
		String str = s.serve(readFile("request.xml"));
		
		System.out.println("Reply is: " + str);
		
		cc.close();
		
	
	}

	static String readFile(String file) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new Demo().getClass().getResourceAsStream(file)));
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str= br.readLine())!=null) {
			sb.append(str);
		}
		return sb.toString();
	}
}
