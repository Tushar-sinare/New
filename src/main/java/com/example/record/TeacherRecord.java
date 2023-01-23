package com.example.record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeacherRecord extends Colleges {
	private static final Logger logger = LoggerFactory.getLogger(TeacherRecord.class);
	protected String branch;
	protected String dept;
	protected String specification;
	public TeacherRecord(College dept, Branch.Engineering branch, Specification specification) {
		super(branch,dept,specification);	
		this.dept = dept.name();
		this.branch = branch.name();
		this.specification = specification.name();
		Map<String,String> teacherDetailsMap=teacherRecordRead();
		fetchRecord(teacherDetailsMap);
}
	public TeacherRecord(College dept, Branch.Graduation branch, Specification specification) {
		super(branch,dept,specification);	
		this.dept = dept.name();
		this.branch = branch.name();
		this.specification = specification.name();
		Map<String,String> teacherDetailsMap=teacherRecordRead();
		fetchRecord(teacherDetailsMap);
	}
	public Map<String , String> teacherRecordRead() {
		String fileName = ".\\" + branch.toLowerCase() + "" + specification.toLowerCase() + "" + dept.toLowerCase()
				+ ".csv";

		Map<String, String> teacherMap = new HashMap<>();

		Path path = Paths.get(fileName);
		if (Files.exists(path)) {
			if (Files.isDirectory(path)) {
				logger.info("It is a directory");
			} else if (Files.isRegularFile(path)) {
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(fileName));
					String[] values;
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						values = line.split(",");
						
						teacherMap.put(values[0], line);
						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			logger.info("File not found ");
		}
return teacherMap;
	}

	
}

