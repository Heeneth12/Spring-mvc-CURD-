package com.telusk.springbootstudents.controller;

import com.telusk.springbootstudents.entity.Student;
import com.telusk.springbootstudents.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    IStudentRepo iStudentRepo;


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/api/student" ,method = RequestMethod.POST)
    public ResponseEntity< Student>  saveStudent(@RequestBody Student student ) {
        return new ResponseEntity<>(iStudentRepo.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/api/student")
    public  ResponseEntity<List<Student>> getStudentS(){
        return  new ResponseEntity<>(iStudentRepo.findAll(),HttpStatus.OK);

    }

    //path peram
    @PutMapping ("/api/student/{id}")
    public ResponseEntity< Student> updateStudentByID(@PathVariable Long id ,@RequestBody Student stud){
        Optional<Student> student = iStudentRepo.findById(id);
        if (student.isPresent()){

            student.get().setStudentName(stud.getStudentName());
            student.get().setStudentEmail(stud.getStudentEmail());
            student.get().setStudentAddress(stud.getStudentAddress());
            return new ResponseEntity<>(iStudentRepo.save(student.get()),HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
    @GetMapping  ("/api/student/{id}")
    public ResponseEntity< Student> getStudentByID(@PathVariable Long id){
        Optional<Student> student = iStudentRepo.findById(id);
        if (student.isPresent()){
            return new ResponseEntity<>(student.get(),HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/api/student/{id}")
    public ResponseEntity<Void> deleteStudentByID(@PathVariable Long id) {
        Optional<Student> student = iStudentRepo.findById(id);
        if (student.isPresent()) {
            iStudentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
