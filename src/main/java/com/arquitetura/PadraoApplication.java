package com.arquitetura;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class PadraoApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PadraoApplication.class);
	}
	
	
	public static void main(String[] args) {
		new PadraoApplication().configure(new SpringApplicationBuilder(PadraoApplication.class)).run(args);
	}

	
	
}
