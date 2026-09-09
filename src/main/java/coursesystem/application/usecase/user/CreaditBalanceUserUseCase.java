package coursesystem.application.usecase.user;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.user.CreditUserInputDTO;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class CreaditBalanceUserUseCase {
  private final UserApplicationMapper mapper;
  private final UserRepository repository;

  public CreaditBalanceUserUseCase(UserApplicationMapper mapper,
                                    UserRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public UserOutputDTO execute(CreditUserInputDTO input) {
    User user = this.repository.findById(input.id()).orElseThrow(() -> new NotFoundException("User Not Found."));
    
    user = this.mapper.update(user, input);
    return this.mapper.toOutput(user);
  }
}
