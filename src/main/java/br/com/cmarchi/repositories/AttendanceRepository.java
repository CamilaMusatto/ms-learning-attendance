package br.com.cmarchi.repositories;

import br.com.cmarchi.domain.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AttendanceRepository extends CrudRepository<Attendance, String> {

    List<Attendance> findByStudentId(UUID studentId);
}
