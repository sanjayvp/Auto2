package com.dice;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import org.testng.ann

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class CSVDataProvider {
@DataProvider(name="CSVDataprovider")
public static Iterator<Object[]> provideData(Method method){
	List<Object[]> list= new ArrayList<Object[]>();
	//String pathname="src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"testData"+ File.separator +method.getDeclaringClass().getSimpleName()+"_"+method.getName()+".csv";
	String pathname="C:\\Users\\sanjay\\eclipse-workspace\\Automation2\\src\\test\\resources\\TestData\\LoginTest_negativeLoginTest.csv";
	File file=new File(pathname);
	try {
		CSVReader reader =new CSVReader (new FileReader(file));
		String[] keys=reader.readNext();
		if(keys!=null) {
			String[] dataParts;
			while ((dataParts=reader.readNext())!=null) {
				Map<String,String> testData=new HashMap<String,String>();
				for (int i = 0; i < keys.length; i++) {
					testData.put(keys[i], dataParts[i]);
				}
				list.add( new Object[] { testData });
			}
			
		}
		reader.close();
	} catch (Exception e) {
		e.getStackTrace().toString();
	}
	
	return list.iterator();
	
}
}
