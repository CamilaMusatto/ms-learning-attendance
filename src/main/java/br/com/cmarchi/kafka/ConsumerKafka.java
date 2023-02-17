package br.com.cmarchi.kafka;

import br.com.cmarchi.domain.Student;
import br.com.cmarchi.service.AttendanceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ConsumerKafka {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private AttendanceService service;

    @KafkaListener(topics = "StudentEvents", groupId = "group_id")
    public void consume(String message){
        try{
            Student student = mapper.readValue(message, Student.class);
            service.saveStudentRedis(student);
            System.out.println("PERSISTIR NO BANCO " + student);
        }catch (Exception e) {
            //e.getMessage();
            System.out.println(e.getMessage());
        }

    }




}
