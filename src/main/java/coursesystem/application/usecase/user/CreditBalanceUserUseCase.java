package coursesystem.application.usecase.user;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.user.CreditBalanceUserInputDTO;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class CreditBalanceUserUseCase {
  private final UserApplicationMapper mapper;
  private final UserRepository repository;

  public CreditBalanceUserUseCase(UserApplicationMapper mapper,
                                    UserRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public UserOutputDTO execute(CreditBalanceUserInputDTO input) {
    User user = this.repository.findById(input.id()).orElseThrow(() -> new NotFoundException("User Not Found."));
    
    user = this.mapper.update(user, input);
    return this.mapper.toOutput(user);
  }
}
