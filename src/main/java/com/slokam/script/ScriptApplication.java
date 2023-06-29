package com.slokam.script;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ScriptApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScriptApplication.class, args);
	}



	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}

}
