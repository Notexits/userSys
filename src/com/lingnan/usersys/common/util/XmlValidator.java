package com.lingnan.usersys.common.util;

import java.io.File;
import java.io.IOException;

import javax.xml.validation.Validator;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

/**
 * @author Administrator
 *	����Schema xsd�ļ���֤ xml �ļ�
 */
public class XmlValidator {
	
	/**
	 * ����Schema xsd�ļ���֤ xml �ļ�
	 * @param xmlPath��xml �ļ���·��
	 * @param xsdPath��xsd �ļ���·��
	 * @return��������֤���
	 */
	public static boolean validate(String xmlPath, String xsdPath) {
		boolean flag = false;
		//��ȡ��ǰ���̵� classpath �� ����·��uri
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		//basePath = /D:/Eclipse/eclipse/SalaryManager/build/classes/
		
		//��������·��
		xmlPath = basePath + xmlPath;
		xsdPath = basePath + xsdPath;

		try {
			
			//����֧��ָ��ģʽ���Ե�  SchemaFactory ��ʵ�ֲ�������
			SchemaFactory factory = 
					SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			
			//������Ϊģʽ��ָ�� File ���� Schema ����ʽ������
			//�˶����ʾ���Ը���  XML �ĵ����/ʵʩ��Լ����
			File file = new File(xsdPath);
			Schema schema = factory.newSchema(file);
			
			//��֤��ʵʩ/���˶����ʾ��Լ������Validator -> ���� Schema ��� XML �ĵ��Ĵ�������
			Validator validator = schema.newValidator();
			
			//��ָ֤�������롣 Source -> ʵ�ִ˽ӿڵĶ�������䵱Դ���루XML Դ��ת��ָ��������Ϣ 
			Source source = new StreamSource(xmlPath);
			validator.validate(source);
			
			flag = true;
		} catch (SAXException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println("��֤�����" + validate("datesource.xml", "datesource.xsd"));
	}
}
