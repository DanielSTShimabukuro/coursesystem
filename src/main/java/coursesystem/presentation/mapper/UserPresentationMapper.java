package coursesystem.presentation.mapper;

import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.presentation.request.user.CreateUserRequestDTO;

public class UserPresentationMapper {
  public CreateUserInputDTO toInput(CreateUserRequestDTO request) {
    return new CreateUserInputDTO(request.email(), request.username(), request.password());
  }
}
