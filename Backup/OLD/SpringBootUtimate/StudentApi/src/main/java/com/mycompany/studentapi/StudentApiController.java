package com.mycompany.studentapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {
    private static List<Student> listStudents = new ArrayList<>();
    public static Integer studentID = 0;

    static {
        listStudents.add(new Student(++studentID, "Douvic"));
        listStudents.add(new Student(++studentID, "Ndilbe"));
    }

    @GetMapping("")
    public ResponseEntity<?> List() {
        if (listStudents.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(listStudents, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        student.setId(++studentID);
        listStudents.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> replace(@RequestBody Student student) {
        if (listStudents.contains(student)) {
            int index = listStudents.indexOf(student);
            listStudents.set(index, student);
            return new ResponseEntity<>(student, HttpStatus.OK);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Student student = new Student(id);
        if (listStudents.contains(student)) {
            listStudents.remove(student);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
