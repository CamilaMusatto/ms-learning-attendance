package br.com.cmarchi.service;

import br.com.cmarchi.model.StudentAttendanceDto;
import br.com.cmarchi.repositories.AttendanceRepository;
import br.com.cmarchi.repositories.StudentRepository;
import br.com.cmarchi.client.CourseClient;
import br.com.cmarchi.domain.Attendance;
import br.com.cmarchi.domain.Student;
import br.com.cmarchi.model.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private CourseClient client;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public void registerStudentAttendance(UUID courseId, UUID studentId, boolean attendanceStatus) {

        if (studentInRedis(studentId) && checkCourseId(courseId)) {

            Attendance attendance = new Attendance(studentId, courseId, attendanceStatus);

            attendanceRepository.save(attendance);

        } else {
            throw new RuntimeException("Deu ruim!");
        }
    }

    @Override
    public StudentAttendanceDto getAttendancesByStudent(UUID studentId) {

        Student student = studentRepository.findById(studentId).get();

        List<Attendance> attendances = attendanceRepository.findByStudentId(studentId);

        String courseName = buildCourseName(student.getCourseId());

        return new StudentAttendanceDto(student.getFullName(), courseName, attendances);
    }

    private boolean studentInRedis(UUID studentId) {
        return studentRepository.findById(studentId).isPresent();
    }

    private boolean checkCourseId(UUID studentId) {
        List<CourseDto> courseResponse = client.buscapeloCourseId(studentId);

        if (courseResponse.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveStudentRedis(Student student) {
        studentRepository.save(student);
    }

    private String buildCourseName(UUID courseId){
        return client.buscapeloCourseId(courseId).get(0).getCourseName();
    }



}
