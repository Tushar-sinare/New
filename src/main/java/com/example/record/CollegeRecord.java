package com.example.record;

import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollegeRecord {
	private static final Logger logger = LoggerFactory.getLogger(CollegeRecord.class);

	public void collegeRecordDetails(String str,Branch.Engineering branch, College dept, Specification specification){
	switch(str) {
	case "S":
		new StudentRecord(College.STUDENT,branch,specification);
		break;
	case "T":
		new TeacherRecord(College.TEACHER,branch,specification);
		break;
	default: 
		logger.info("Invalid Key");
	}
		
		
	}
	public void collegeRecordDetails(String str,Branch.Graduation branch, College dept, Specification specification){
		switch(str) {
		case "S":
			new StudentRecord(College.STUDENT,branch,specification);
			break;
		case "T":
			new TeacherRecord(College.TEACHER,branch,specification);
			break;
		default: 
			logger.info("Invalid Key");
		}	
		
	}


}
