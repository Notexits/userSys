package com.lingnan.usersys.common.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XmlParser{
	private static Map<String, String> map = null;
	
	public static boolean parser(String xmlPath) {
		boolean flag = false;
		
		//��ȡ��ǰ���̵� classpath �� ����·��uri
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//basePath = /D:/Eclipse/eclipse/SalaryManager/build/classes/
		
		//��������·��
		xmlPath = basePath + xmlPath;
		try {
			//���幤�� API��ʹӦ�ó����ܹ����úͻ�ȡ���� SAX �Ľ������Խ��� XML �ĵ�
			SAXParserFactory factory = SAXParserFactory.newInstance();
			
			//ʹ�õ�ǰ���õĹ����������� SAXParser ��һ����ʵ����
			SAXParser saxParser = factory.newSAXParser();
			
			File file = new File(xmlPath);
			XmlHandler handler = new XmlHandler();
			
			//ʹ��ָ����  Handler ��ָ���ļ������ݽ���Ϊ XML
			saxParser.parse(file, handler);
			map = handler.getMap();
			flag = true;
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	public static Map<String, String> getParserMap(){
		return map;
	}
	
	public static void main(String[] args) {
		boolean isSuccess = parser("datesource.xml");
		System.out.println("���������" + isSuccess);
		for(Map.Entry<String, String> entry : getParserMap().entrySet()) {
			System.out.println("--" + entry.getKey() + "   " + entry.getValue());
		}
	}
}
