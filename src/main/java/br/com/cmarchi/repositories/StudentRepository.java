package br.com.cmarchi.repositories;

import br.com.cmarchi.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {

    Student findByFullName(String fullName);

    Student findByCourseId(UUID courseId);
}
