package coursesystem.application.usecase.user;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.user.DebitBalanceUserInputDTO;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class DebitBalanceUserUseCase {
  private final UserApplicationMapper mapper;
  private final UserRepository repository;

  public DebitBalanceUserUseCase(UserApplicationMapper mapper,
                                  UserRepository repository) {
    this.mapper = mapper;
    this.repository = repository;                                  
  }

  public UserOutputDTO execute(DebitBalanceUserInputDTO input) {
    User user = this.repository.findById(input.id()).orElseThrow(() -> new NotFoundException("User Not Found."));
    
    user = this.mapper.update(user, input);
    this.repository.save(user);

    return this.mapper.toOutput(user);
  }
}
