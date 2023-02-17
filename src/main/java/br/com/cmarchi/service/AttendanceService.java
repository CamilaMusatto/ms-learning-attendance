package br.com.cmarchi.service;

import br.com.cmarchi.domain.Student;
import br.com.cmarchi.model.StudentAttendanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface AttendanceService {



    void saveStudentRedis(Student student);

    void registerStudentAttendance(UUID courseId, UUID studentId, boolean attendanceStatus);


    StudentAttendanceDto getAttendancesByStudent(UUID studentId);
}
