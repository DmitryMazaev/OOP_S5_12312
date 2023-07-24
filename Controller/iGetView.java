package Controller;

import java.util.HashMap;
import java.util.List;

import Model.Student;

public interface iGetView {
    void printAllStudents(List<Student> students);
    void printAllHashMapStudents(HashMap<Long, Student> hashMapStudents);
    String prompt(String msg);
}
