package coursesystem.application.usecase.user;

import java.util.UUID;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;

public class DeleteUserUseCase {
  private final UserRepository repository;

  public DeleteUserUseCase(UserRepository repository) {
    this.repository = repository;
  }

  public void execute(UUID id) {
    User user = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found."));

    this.repository.delete(user);
  }
}
