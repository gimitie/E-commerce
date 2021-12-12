package br.com.giovana.microservice.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class LojaApplication {

	@Bean
	@LoadBalanced /*faz com que o resttemplate consiga resolver a requisicao .../fornecedor*/
	@Primary
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

}