package ru.geekbrains.boot.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.boot.model.Student;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class StudentInMemoryRepository {
    private List<Student> students;

    @PostConstruct
    public void init() {
        this.students = new ArrayList<>(Arrays.asList(
                new Student(1L, "Bob", 70),
                new Student(2L, "John", 80),
                new Student(3L, "Jack", 60)
        ));
    }

    public Student saveOrUpdate(Student s) {
        if (s.getId() != null) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(s.getId())) {
                    students.set(i, s);
                    return s;
                }
            }
        }

        Long newId = students.stream().mapToLong(Student::getId).max().orElseGet(() -> 0L) + 1L;
        s.setId(newId);
        students.add(s);
        return s;
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(students);
    }

    public Optional<Student> findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}
