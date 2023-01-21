package com.example.colleagestaff;

import java.util.Scanner;
import com.example.specification.SpecificationDept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColleageAdmin {
	private static final Logger logger = LoggerFactory.getLogger(ColleageAdmin.class);


	public void callToObject(String s) {
		if(s!=null && !s.isEmpty()) {
	switch(s.toUpperCase()) {
	case "S" :
		callToSpecification(College.STUDENT);
		break;
	case "T" :
		callToSpecification(College.TEACHER);
		break;
	case "P" :
		callToSpecification(College.PRINCIPLE);
		break;
		default: 
		logger.info("Invalid Key");
	}
	}
	}
	public void callToSpecification(College str) {
		SpecificationDept specificationDept =new SpecificationDept(str);
		System.out.println("Enter a Key For Operation :\n E:Engineering \n G:Graduation \n ");
		Scanner sc = new Scanner(System.in);
			String spec = sc.next();
			if(!spec.isEmpty()) {
			specificationDept.specificationDetails(spec);
			}else {
				logger.info("Please insert key do not null pass");
			}
		}

	
	public static void main(String[] args) {
		ColleageAdmin colleageAdmin =new ColleageAdmin();
		logger.info("Enter a Key For Operation :\n S:Student \n T:Teacher \n P:Principle \n");
	Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		colleageAdmin.callToObject(s);
	}
	}


