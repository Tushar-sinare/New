package com.example.record;

import com.example.colleagestaff.College;
import com.example.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllTeacherRecord {
	private static final Logger logger = LoggerFactory.getLogger(AllTeacherRecord.class);
	String dept;
	String specification;
public AllTeacherRecord(College dept,Specification specification) {
	
	this.dept = dept.name();
	this.specification = specification.name();
	List<String> teacherDetailsList=allTeacherDataBranch();
	fetchTeacherRecord(teacherDetailsList);
}

public List<String> allTeacherDataBranch() {
	List<String> teacherList = new ArrayList<>();
	if(!specification.equals("ENGINEERING")) {
		String[] fileName = {".\\" + "bca" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bba" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bcom" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bsc" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv",".\\" + "bcs" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
		+ ".csv"};
		for(int i=0;i<fileName.length;i++) {
		String fileName1 = fileName[i];
		Path path = Paths.get(fileName1);
		if (Files.exists(path)) {
			if (Files.isDirectory(path)) {
				logger.info("It is a directory");
			} else if (Files.isRegularFile(path)) {
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(fileName1));
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						teacherList.add(line);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					if(bufferedReader!=null) {
						try {
							bufferedReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}

		} 
	}
}else {
	String[] fileName = {".\\" + "civil" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "mechanical" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "it" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "computer" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv",".\\" + "entc" + "" + specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv"};for(int i=0;i<fileName.length;i++) {
		String fileName1 = fileName[i];
		Path path = Paths.get(fileName1);
		if (Files.exists(path)) {
			if (Files.isDirectory(path)) {
				logger.info("It is a directory");
			} else if (Files.isRegularFile(path)) {
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(fileName1));
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						teacherList.add(line);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} 
	}
	
}
	return teacherList;
}
public void fetchTeacherRecord(List<String>teacherDetailsList) {
	int count = 0;
	String filename = "All"+specification.toLowerCase() + "" + dept.toLowerCase()
	+ ".csv";
	File file = new File(filename);
	FileWriter fileWrite =null;
	Map<String,String> teacherListHeader = new HashMap<>();
	try {
		file.createNewFile();
	try {
		fileWrite = new FileWriter(file);
	for(String teacherList:teacherDetailsList){
		
		String str ="Emp No";
		if(teacherList.contains(str)) {
			teacherListHeader.put(str, teacherList);
		}
	}
	for(Map.Entry<String, String> me:teacherListHeader.entrySet()) {
		logger.info(me.getValue());
		fileWrite.write(me.getValue()+"\n");
	}
	
for(String teacherList:teacherDetailsList){
		
		String str ="Emp No";
		if(!teacherList.contains(str)) {
		logger.info(teacherList);
		fileWrite.write(teacherList+"\n");
		count++;
		}
	}
	
	logger.info("\n Total "+dept + " of "+specification +": "+ count);
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(fileWrite !=null) {
			try {
				fileWrite.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}catch(Exception e) {
	e.printStackTrace();
}
	}
}
