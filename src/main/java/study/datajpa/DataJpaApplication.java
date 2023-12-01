package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	/**
	 * @CreatedBy @LastModifiedBy 애노테이션이 붙은 필드에 값을 초기화시켜준다.
	 */
	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.of(UUID.randomUUID().toString());
	}
}
