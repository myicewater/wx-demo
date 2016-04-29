package com.link.common.util;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析xml
 * @author 朱素海
 *
 */
public class XmlUtil {

	
	public static  Map<String,String> parsemXml(String source){
		Map<String,String> resultMap = new HashMap<String,String>();
		try{
			SAXReader reader = new SAXReader();
			Document document = reader.read(new ByteArrayInputStream(source.getBytes("utf-8")));
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			
			for(Element element:elements){
				resultMap.put(element.getName(),element.getText() );
			}
			
		}catch(Exception e){
			
		}
		
		
		
		
		return resultMap;
	}
	
	
	public static Map<String,String> parsemXml2(String source){
		Map<String,String> resultMap = new HashMap<String,String>();
		try{
			Document document = DocumentHelper.parseText(source);
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> elements = root.elements();
			
			for(Element element:elements){
				resultMap.put(element.getName(),element.getText() );
			}
			
		}catch(Exception e){
			
		}
		return resultMap;
	}
	
	
	public static String beanToString(){
		
		return "";
	}
}
