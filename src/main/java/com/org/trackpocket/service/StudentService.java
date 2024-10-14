package com.org.trackpocket.service;

import com.org.trackpocket.database.StudentRepo;
import com.org.trackpocket.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepository;

    // Fetch all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Fetch a student by ID
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    // Save a new student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Delete a student by ID
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
