package coursesystem.application.usecase;

import java.util.UUID;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class FindUserByIdUseCase {
  private final UserApplicationMapper mapper;
  private final UserRepository repository;
  
  public FindUserByIdUseCase(UserApplicationMapper mapper,
                              UserRepository repository) {
    this.mapper = mapper;
    this.repository = repository;                              
  }

  public UserOutputDTO execute(UUID id) {
    User user = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found."));

    return this.mapper.toOutput(user);
  }
}
