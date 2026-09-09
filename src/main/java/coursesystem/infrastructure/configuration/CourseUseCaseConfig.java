package coursesystem.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import coursesystem.application.mapper.CourseApplicationMapper;

@Configuration 
public class CourseUseCaseConfig {
  @Bean 
  CourseApplicationMapper courseApplicationMapper() {
    return new CourseApplicationMapper();
  }
}
