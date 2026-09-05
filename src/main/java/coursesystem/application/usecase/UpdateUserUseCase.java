package coursesystem.application.usecase;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.mapper.UserApplicationMapper;
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

  private void validateUser(User user) {
    if (this.repository.existsByEmailAndIdNot(user.email(), user.id())) throw new BusinessException("Email Already Exists.");
    
    if (this.repository.existsByUsernameAndIdNot(user.username(), user.id())) throw new BusinessException("Username Already Exists.");
  }
}
