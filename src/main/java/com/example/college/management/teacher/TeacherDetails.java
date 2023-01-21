package com.example.college.management.teacher;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.address.Address;
import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.record.Colleges;
import com.example.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class TeacherDetails extends Colleges {
	private static final Logger logger = LoggerFactory.getLogger(TeacherDetails.class);

	protected String branch;
	protected String dept;
	protected String specification;
	List<Teacher> teacherDetail;
	public TeacherDetails(Branch.Engineering branch, College dept, Specification specification) {
		super(branch,dept,specification);	
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification = specification.name();
		List<Teacher> teacherList = addTeacherDetails();
		writeTeacherDetailsFile(teacherList);
	}
	public TeacherDetails(Branch.Graduation branch, College dept, Specification specification) {
		super(branch,dept,specification);	
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification = specification.name();
		List<Teacher> teacherList = addTeacherDetails();
		writeTeacherDetailsFile(teacherList);
	}
	public List<Teacher> addTeacherDetails() {
		teacherDetail = new ArrayList<>();
		logger.info("\nPlease Fill Teacher Details\n");
		Scanner sc = new Scanner(System.in);
			logger.info("Enter Your Emp ID : ");
			int rollNo = sc.nextInt();
			sc.nextLine();
		logger.info("Enter Your Name : ");
			String name = sc.nextLine();
		logger.info("Enter Your Mobile No : ");
			Long mobileNo = sc.nextLong();
			sc.nextLine();
		logger.info("Enter Your Email Id : ");
			String emailId = sc.nextLine();
		logger.info("Enter Your Subject : ");
			String subSpecific = sc.nextLine();
		logger.info("Enter Your Current Address : ");
			String cAddress = sc.nextLine();
		logger.info("Enter Your Permanent Address : ");
			String pAddress = sc.nextLine();
			Address address = new Address(cAddress,pAddress);
			teacherDetail.add(new Teacher(rollNo, name, mobileNo, emailId, subSpecific, address, specification, branch));
				return teacherDetail;
	}

	


}