package br.com.cmarchi.model;

import br.com.cmarchi.domain.Attendance;

import java.util.List;

public class StudentAttendanceDto {

    private String fullName;
    private String courseName;
    private List<Attendance> attendances;

    public StudentAttendanceDto(){}

    public StudentAttendanceDto(String fullName, String courseName, List<Attendance> attendances) {
        this.fullName = fullName;
        this.courseName = courseName;
        this.attendances = attendances;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
