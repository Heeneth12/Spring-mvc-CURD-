package com.telusk.springbootstudents.repo;
import com.telusk.springbootstudents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IStudentRepo extends JpaRepository<Student , Long> {
}
