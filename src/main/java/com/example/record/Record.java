package com.example.record;

import java.util.List;
import java.util.Map;

import com.example.college.management.student.Student;
import com.example.college.management.teacher.Teacher;
interface Record {
void writeStudentDetailsFile(List<Student> student);
void writeTeacherDetailsFile(List<Teacher> teacher);	
void fetchRecord(Map<String,String>detailsMap);
}
