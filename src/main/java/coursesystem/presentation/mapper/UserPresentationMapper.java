package coursesystem.presentation.mapper;

import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.presentation.request.user.CreateUserRequestDTO;
import coursesystem.presentation.response.user.UserResponseDTO;

public class UserPresentationMapper {
  public CreateUserInputDTO toInput(CreateUserRequestDTO request) {
    return new CreateUserInputDTO(request.email(), request.username(), request.password());
  }

  public UserResponseDTO toResponse(UserOutputDTO output) {
    return new UserResponseDTO(output.id(),
                              output.email(),
                              output.username(),
                              output.createdAt(),
                              output.updatedAt(),
                              output.userCourseIds());
  }
}
