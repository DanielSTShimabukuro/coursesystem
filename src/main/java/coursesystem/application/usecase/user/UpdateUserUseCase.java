package coursesystem.application.usecase.user;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.user.UpdateUserInputDTO;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class UpdateUserUseCase {
  private final UserApplicationMapper mapper;
  private final UserRepository repository;

  public UpdateUserUseCase(UserApplicationMapper mapper,
                            UserRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public UserOutputDTO execute(UpdateUserInputDTO input) {
    User user = this.repository.findById(input.id()).orElseThrow(() -> new NotFoundException("User Not Found."));

    user = this.mapper.update(user, input);
    this.validateUser(user);
    this.repository.save(user);

    return  this.mapper.toOutput(user);
  }

  private void validateUser(User user) {
    if (this.repository.existsByEmailAndIdNot(user.email(), user.id())) throw new BusinessException("Email Already Exists.");
    
    if (this.repository.existsByUsernameAndIdNot(user.username(), user.id())) throw new BusinessException("Username Already Exists.");
  }
}
