package com.driver;

import org.springframework.stereotype.Repository;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class combinedRepository {
    private HashMap<String, Student>studentsDatabase;
    private HashMap<String, Teacher>teachersDatabase;
    private HashMap<String, List<Student>>pairDatabase;
    combinedRepository(){
        studentsDatabase=new HashMap<>();
        teachersDatabase=new HashMap<>();
        pairDatabase=new HashMap<>();
    }

    public HashMap<String, Student> getStudentsDatabase() {
        return studentsDatabase;
    }

    public HashMap<String, Teacher> getTeachersDatabase() {
        return teachersDatabase;
    }

    public void setStudentsDatabase(HashMap<String, Student> studentsDatabase) {
        this.studentsDatabase = studentsDatabase;
    }

    public void setTeachersDatabase(HashMap<String, Teacher> teachersDatabase) {
        this.teachersDatabase = teachersDatabase;
    }

    public HashMap<String, List<Student>> getPairDatabase() {
        return pairDatabase;
    }

    public void setPairDatabase(HashMap<String, List<Student>> pairDatabase) {
        this.pairDatabase = pairDatabase;
    }

    //Method 1: add Student
    public String addStudent(Student student){
//        if(getStudentsDatabase().containsKey(student)==false) {
            getStudentsDatabase().put(student.getName(), student);
            return "New student added successfully";
//        }else{
//            return "New student not added successfully";
//        }
    }

    //Method 2: add Teacher
    public String addTeacher(Teacher teacher){
//        if(getTeachersDatabase().containsKey(teacher.getName())==false) {
            getTeachersDatabase().put(teacher.getName(), teacher);
            return "New teacher added successfully";
//        }else{
//            return "New teacher not added successfully";
//
//        }
    }

    //Method 3: add Student and teacher
    public String addStudentTeacherPair(String student, String teacher){
//        if(getTeachersDatabase().containsKey(teacher)==true && getStudentsDatabase().containsKey(student)==true){
            List<Student>students= getPairDatabase().getOrDefault(teacher,new ArrayList<>());
            students.add(getStudentsDatabase().get(student));
            getPairDatabase().put(teacher,students);
            return "New student-teacher pair added successfully";
//        }
//        else{
//            return "New student-teacher pair not added successfully";
//        }

    }


}
