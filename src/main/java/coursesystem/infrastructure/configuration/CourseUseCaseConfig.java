package coursesystem.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.application.usecase.course.CreateCourseUseCase;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.domain.repository.UserRepository;

@Configuration 
public class CourseUseCaseConfig {
  @Bean 
  CourseApplicationMapper courseApplicationMapper() {
    return new CourseApplicationMapper();
  }

  @Bean 
  CreateCourseUseCase createCourseUseCase(CourseApplicationMapper mapper, UserRepository userRepository, CourseRepository repository) {
    return new CreateCourseUseCase(mapper, userRepository, repository);
  }
}
