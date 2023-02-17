package br.com.cmarchi.controller;

import br.com.cmarchi.domain.Attendance;
import br.com.cmarchi.model.AttendanceStatusDto;
import br.com.cmarchi.model.StudentAttendanceDto;
import br.com.cmarchi.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name= "Attendance", description = "Endpoints for managing attendances")
@RestController
@RequestMapping("/api/v1")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @Operation(summary = "Register attendance", description = "record the presence or absence of students",
    tags = {"Attendance"},
    responses = {
            @ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content (mediaType = "application/json",
                            schema = @Schema (implementation = Attendance.class))
            })
    })
    @PostMapping(value = "/course/{courseId}/student/{studentId}/attendance",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerStudentAttendance(@PathVariable(value = "courseId") UUID courseId,
                                                       @PathVariable(value = "studentId") UUID studentId,
                                                       @RequestBody AttendanceStatusDto attendanceStatus){

        System.out.println(attendanceStatus);
        service.registerStudentAttendance(courseId, studentId, attendanceStatus.getStatus());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search attendances", description = "Get a attendances of students",
    tags = "Attendance", responses = {
            @ApiResponse(description = "Sucess", responseCode = "200",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = StudentAttendanceDto.class )))
    })
    @GetMapping(value = "/student/{studentId}/attendances", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentAttendanceDto> getAttendancesByStudent(@PathVariable(value = "studentId") UUID studentId){

        return ResponseEntity.ok(service.getAttendancesByStudent(studentId));
    }






}
