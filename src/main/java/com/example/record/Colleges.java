package com.example.record;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.branch.Branch;
import com.example.colleagestaff.College;
import com.example.college.management.student.Student;
import com.example.college.management.teacher.Teacher;
import com.example.specification.Specification;

public abstract class Colleges implements Record {
	String branch;
	String dept;
	String specification;
	
	protected Colleges(Branch.Engineering branch, College dept, Specification specification){
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification=specification.name();
		
		
	}
	protected Colleges(Branch.Graduation branch, College dept, Specification specification){
		this.branch = branch.name();
		this.dept = dept.name();
		this.specification=specification.name();
		
	}
	
	public void writeStudentDetailsFile(List<Student> studentList) {
		int rollNoList=0;
		List<String> rollNo = new ArrayList<>();
		String[] values=null;
		String fileName = ".\\"+branch.toLowerCase()+""+specification.toLowerCase()+""+dept.toLowerCase()+".csv";
		File file = new File(fileName);
		BufferedReader bufferedReader = null;
		FileWriter fileWrite;
		try {
			file.createNewFile();
			
			fileWrite = new FileWriter(file,true);
			if(file.length()==0) {
				fileWrite.write("Roll No,"+"Student Name,"+"Student Mobile No,"+"Student Email,"+"Student Current Address,"+"Student Permanent Address,"+"Student Branch,"+"Student Specification\n");
			}
			bufferedReader = new BufferedReader(new FileReader(file));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
			try {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					values = line.split(",");
					rollNo.add(values[0]);
				}
				for(Student s:studentList) {
				for(String roll:rollNo) {
					if(roll.contains(Integer.toString(s.getStudentRollNo()))) {
						rollNoList = Integer.parseInt(roll);
					}
				}
				}
				for(Student student:studentList) {
					if(file.length() == 0){
					bufferedWriter.append(student.getStudentRollNo()+","+student.getStudentName() +","+student.getStudentMobileNo()+","+student.getStudentEmail()+","+student.address+","+student.getBranch()+", "+student.getSpecification()+"\n");
					System.out.println("Record Created Succesfully");
					System.out.println("Please Check Record in File : "+fileName);
				}else if (rollNoList!=student.getStudentRollNo()) {
					bufferedWriter.append(student.getStudentRollNo()+","+student.getStudentName() +","+student.getStudentMobileNo()+","+student.getStudentEmail()+","+student.address+","+student.getBranch()+", "+student.getSpecification()+"\n");
					System.out.println("Record Created Succesfully");
					System.out.println("Please Check Record in File : "+fileName);
				}else {
					System.err.println("Roll Numberd Already Exists");
					break;
				}
			}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(bufferedWriter!=null) {
						bufferedWriter.close();
						fileWrite.close();					}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void writeTeacherDetailsFile(List<Teacher> teacherList) {
		int empNoList=0;
		List<String> empNo = new ArrayList<>();
		String[] values=null;
		String fileName = ".\\" + branch.toLowerCase() + "" + specification.toLowerCase() + "" + dept.toLowerCase()
				+ ".csv";
		File file = new File(fileName);
		BufferedReader bufferedReader = null;
		FileWriter fileWrite;
		try {

			boolean fileCreated = file.createNewFile();
			if (!fileCreated) {
			    throw new IOException("Unable to create file at specified path. It already exists");
			}

			fileWrite = new FileWriter(file, true);
			if (file.length() == 0) {
				fileWrite.write("Emp No ," + "Teacher Name ," + "Teacher Mobile No," + "Teacher Email ,"
						+ "Teacher Subject ," + "Teacher Current Address ," + "Teacher Permanent Address ," + "Teacher Branch," + "Teacher Specification\n");
			}
			bufferedReader = new BufferedReader(new FileReader(file));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
			try {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					values = line.split(",");
					empNo.add(values[0]);
				}
				for(Teacher t:teacherList) {
				for(String emp:empNo) {
					if(emp.contains(Integer.toString(t.getTeacherID()))) {
						empNoList = Integer.parseInt(emp);
					}
				}
				}
				for (Teacher teacher : teacherList) {
					if(file.length() == 0){
						bufferedWriter.append(teacher.getTeacherID() + "," + teacher.getTeacherName() + ","
								+ teacher.getTeacherMobileNo() + "," + teacher.getTeacherEmail() + ","
								+ teacher.getTeacherTeachSubject() + "," + teacher.teacherAddress+ ","
								+ teacher.getBranch() + ", " + teacher.getSpecification() + "\n");
						System.out.println("Record Created Succesfully1");
						System.out.println("Please Check Record in File : "+fileName);
					}else if (empNoList!=teacher.getTeacherID()) {
						bufferedWriter.append(teacher.getTeacherID() + "," + teacher.getTeacherName() + ","
								+ teacher.getTeacherMobileNo() + "," + teacher.getTeacherEmail() + ","
								+ teacher.getTeacherTeachSubject() + "," + teacher.teacherAddress+ ","
								+ teacher.getBranch() + ", " + teacher.getSpecification() + "\n");
						System.out.println("Record Created Succesfully");
						System.out.println("Please Check Record in File : "+fileName);
					} else {
						System.err.println("Roll Numberd Already Exists");
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bufferedWriter != null) {
						bufferedWriter.close();
						fileWrite.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fetchRecord(Map<String,String>teacherDetailsMap) {
		int count = 0;
		String str ="Emp No";
		String strroll = "Roll No";
		for(Map.Entry<String,String> me:teacherDetailsMap.entrySet()){
			
			
			if(me.getKey().contains(str)||me.getKey().contains(strroll)) {
			System.out.println(me.getValue());
			}
		}
		
		for(Map.Entry<String,String> me:teacherDetailsMap.entrySet()){
		
			if(!me.getKey().contains(str)||me.getKey().contains(strroll)) {
				count++;
			System.out.println(me.getValue());
			}
			}
		System.out.println("\n Total "+dept + " of "+branch +": "+ count);
	}
		
}
	


