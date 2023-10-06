package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class combinedService {
    @Autowired
    public combinedRepository repoObj;

    //Method 1: add Student
    public String addStudent(Student student){
        HashMap<String, Student>studentsDb=repoObj.getStudentsDatabase();
        if(studentsDb.containsKey(student.getName())==false)
        return repoObj.addStudent(student);
        else return "";
    }

    //Method 2: add Teacher
    public String addTeacher(Teacher teacher){
        HashMap<String, Teacher>teachersDb=repoObj.getTeachersDatabase();
        if(teachersDb.containsKey(teacher.getName())==false)
        return repoObj.addTeacher(teacher);
        else return "";
    }

    //Method 3: add Student teacher pair
    public String addStudentTeacherPair(String student, String teacher){
        return repoObj.addStudentTeacherPair(student, teacher);
    }

    //Method 4: get student by name
    public Student getStudentByName(String student){
        HashMap<String, Student>studentDb=repoObj.getStudentsDatabase();
        if(studentDb.containsKey(student)==true){
            return studentDb.get(student);
        }else{
            return null;
        }
    }

    //Method 5: get teacher by name
    public Teacher getTeacherByName(String teacher){
        HashMap<String,Teacher>teacherDb=repoObj.getTeachersDatabase();
        if(teacherDb.containsKey(teacher)==true){
            return teacherDb.get(teacher);
        }else{
            return null;
        }
    }

    //Method 6: get students by teacher name
    public List<String> getStudentsByTeacherName(String teacher){
        HashMap<String, List<Student>>pairDb=repoObj.getPairDatabase();
        if(pairDb.containsKey(teacher)){
            List<String>students=new ArrayList<>();
            for(Student student:pairDb.get(teacher))students.add(student.getName());
            return students;
        }else{
            return new ArrayList<>();
        }
    }

    //Method 7: get All Students names
    public List<String> getAllStudents(){
        HashMap<String, Student>studentDb=repoObj.getStudentsDatabase();
        if(studentDb!=null){
            List<String>studentsNames=new ArrayList<>();
            for(String name:studentDb.keySet()){
                studentsNames.add(name);
            }
            return studentsNames;
        }else {
            return new ArrayList<>();
        }
    }

    //Method 8: delete Teacher By Name
    public String deleteTeacherByName(String teacher){
        HashMap<String,Teacher>teacherDb=repoObj.getTeachersDatabase();
        HashMap<String, List<Student>>pairDb=repoObj.getPairDatabase();
        if(teacherDb==null || teacherDb.size()==0 ||teacherDb.containsKey(teacher)==false)return " teacher not found";
        teacherDb.remove(teacher);
        pairDb.remove(teacher);
        return " removed successfully";
    }

    //Method 9: deleteAllTeachers
    public String deleteAllTeachers(){
        HashMap<String,Teacher>teacherDb=repoObj.getTeachersDatabase();
        HashMap<String, List<Student>>pairDb=repoObj.getPairDatabase();
        if(teacherDb==null ||teacherDb.size()==0)return " teachers not found";
        teacherDb.clear();
        pairDb.clear();
        return "All teachers deleted successfully";
    }
}
