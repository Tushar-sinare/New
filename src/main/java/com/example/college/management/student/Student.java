package com.example.college.management.student;

import com.example.address.Address;

public class Student {
private int studentRollNo;
private String studentName;
private Long studentMobileNo;
private String studentEmail;

private String specification;
private String branch;
public static Address add;
public int getStudentRollNo() {
	return studentRollNo;
}
public String getStudentName() {
	return studentName;
}
public Long getStudentMobileNo() {
	return studentMobileNo;
}
public String getStudentEmail() {
	return studentEmail;
}
public String getSpecification() {
	return specification;
}
public String getBranch() {
	return branch;
}
public Student() {

	super();
}
public Student(int studentRollNo, String studentName, Long studentMobileNo, String studentEmail,
		Address pAddress, String specification, String branch) {
	super();
	this.studentRollNo = studentRollNo;
	this.studentName = studentName;
	this.studentMobileNo = studentMobileNo;
	this.studentEmail = studentEmail;
	this.add = pAddress;
	this.specification = specification;
	this.branch = branch;
}
@Override
public String toString() {
	return "Student [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentMobileNo="
			+ studentMobileNo + ", studentEmail=" + studentEmail + ", studentAddress=" + add
			+ ", specification=" + specification + ", branch=" + branch + "]";
}

}
