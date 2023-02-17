package br.com.cmarchi.client;

import br.com.cmarchi.model.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Component
@FeignClient(url = "localhost:8081/api/v1", name = "course")
public interface CourseClient {

    @GetMapping("/courses")
    List<CourseDto> buscapeloCourseId(@RequestParam("courseId") UUID courseId);



}
