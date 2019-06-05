package com.wendao.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * ��ϤSAX��������
 * @author china
 *
 */
public class XmlTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// 1. 
		SAXParserFactory fac = SAXParserFactory.newInstance();
		// 2. 
		SAXParser parser = fac.newSAXParser();
		// 3. 
		PHandler handler = new PHandler();
		parser.parse(Thread.currentThread().
				getContextClassLoader().
				getResourceAsStream("com/wendao/server/basic/p.xml"), handler);
	}
}

class PHandler extends DefaultHandler{
	public PHandler() {
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("--- �ĵ����� ��ʼ ---");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"Ԫ�ؽ��� ��ʼ -->");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (contents.length()>0) {
			System.out.println("	content:"+contents);
		} else {
			System.out.println("���� ��");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"Ԫ�ؽ��� ���� <--");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("--- �ĵ����� ���� ---");
	}
}












