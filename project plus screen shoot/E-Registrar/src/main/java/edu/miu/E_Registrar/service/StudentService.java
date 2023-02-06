package edu.miu.E_Registrar.service;


import edu.miu.E_Registrar.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentService {
   Student addNewStudent(Student newStudent);
   Student getStudentById(Integer studentId);
   Student updateStudent(Student student);
   void deleteStudentById(Integer studentId);

   //    @Override
   //    public Iterable<Student> getAllStudents() {
   //        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
   //    }

   // List<Student> searchStudent(String searchString);
   Page<Student> getAllStudentsPaged(Integer pageNo);
   Iterable<Student> getAllStudents();
}
