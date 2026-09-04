package coursesystem.application.usecase;

import coursesystem.application.dto.input.user.CreateUserInputDTO;
import coursesystem.application.dto.mapper.UserDTOMapper;
import coursesystem.application.dto.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class CreateUserUseCase {
  private final UserRepository repository;
  private final UserDTOMapper mapper;

  public CreateUserUseCase(UserRepository repository,
                            UserDTOMapper mapper
  ) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public UserOutputDTO execute(CreateUserInputDTO input) {
    User user = this.mapper.toDomain(input);

    user = this.repository.save(user);

    return this.mapper.toOutput(user);
  }
}
