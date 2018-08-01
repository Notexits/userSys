package com.lingnan.usersys.common.util;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler{
	
	//������ʱ�洢��Xml�н����������ַ���
	private StringBuffer buffer = new StringBuffer();
	
	//�����洢��Xml�ж�ȡ�����ַ���������Xml �ļ��е�Ԫ����     ֵ��Ԫ��ֵ
	//����<driverClass>com.mysql.jdbc.Driver</driverClass> 
	//����driverClass ֵ��com.mysql.jdbc.Driver
	private Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * @return:���ش洢�Ŵ� xml �ļ��ж�ȡ������Ϣ�� Map ����
	 */
	public Map<String, String> getMap(){
		return map;
	}
	
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		//����Ԫ�صĿ�ͷʱ������ַ�����
		buffer.delete(0, buffer.length());
	}
	
	
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		//����Ԫ��ֵʱ�����ַ���������Ӹ�Ԫ��ֵ
		buffer.append(arg0, arg1, arg2);
	}
	
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		//�Ѹ��ַ�����ŵ� map �����args ����ΪԪ����
		map.put(arg2, buffer.toString().trim());
		
	}
}
