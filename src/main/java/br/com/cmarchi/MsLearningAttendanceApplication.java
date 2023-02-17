package br.com.cmarchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsLearningAttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLearningAttendanceApplication.class, args);
	}

}
