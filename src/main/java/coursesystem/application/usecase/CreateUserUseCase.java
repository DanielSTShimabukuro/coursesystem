package coursesystem.application.usecase;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class CreateUserUseCase {
  private final UserApplicationMapper mapper;
  private final UserRepository repository;

  public CreateUserUseCase(UserApplicationMapper mapper,
                            UserRepository repository
  ) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public UserOutputDTO execute(CreateUserInputDTO input) {
    User user = this.mapper.toDomain(input);

    this.validateUser(user);

    user = this.repository.save(user);

    return this.mapper.toOutput(user);
  }

  private void validateUser(User user) {
    if (this.repository.existsByEmail(user.email())) throw new BusinessException("Email Already Exists.");

    if (this.repository.existsByUsername(user.username())) throw new BusinessException("Username Already Exists.");
  }
}
