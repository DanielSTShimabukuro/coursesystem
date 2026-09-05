package coursesystem.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.usecase.CreateUserUseCase;
import coursesystem.application.usecase.FindUserByIdUseCase;
import coursesystem.domain.repository.UserRepository;

@Configuration
public class UserUseCaseConfig {
  @Bean
  CreateUserUseCase createUserUseCase(UserApplicationMapper mapper, UserRepository repository) {
    return new CreateUserUseCase(mapper, repository);
  }

  @Bean 
  FindUserByIdUseCase findUserByIdUseCase(UserApplicationMapper mapper, UserRepository repository) {
    return new FindUserByIdUseCase(mapper, repository);
  }
}
