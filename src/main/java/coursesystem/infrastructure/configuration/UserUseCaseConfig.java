package coursesystem.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.usecase.CreateUserUseCase;
import coursesystem.application.usecase.DeleteUserUseCase;
import coursesystem.application.usecase.FindUserByIdUseCase;
import coursesystem.application.usecase.UpdateUserUseCase;
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

  @Bean 
  UpdateUserUseCase updateUserUseCase(UserApplicationMapper mapper, UserRepository repository) {
    return new UpdateUserUseCase(mapper, repository);
  }

  @Bean
  DeleteUserUseCase deleteUserUseCase(UserRepository repository) {
    return new DeleteUserUseCase(repository);
  }
}
