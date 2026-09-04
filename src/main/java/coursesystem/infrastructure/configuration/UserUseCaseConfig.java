package coursesystem.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import coursesystem.application.dto.mapper.UserDTOMapper;
import coursesystem.application.usecase.CreateUserUseCase;
import coursesystem.domain.repository.UserRepository;

@Configuration
public class UserUseCaseConfig {
  @Bean
  CreateUserUseCase createUserUseCase(UserRepository repository, UserDTOMapper mapper) {
    return new CreateUserUseCase(repository, mapper);
  }
}
