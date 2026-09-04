package coursesystem.application.dto.mapper;

import coursesystem.application.dto.input.user.CreateUserInputDTO;
import coursesystem.application.dto.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;

public class UserDTOMapper {
  public User toDomain(CreateUserInputDTO input) {
    return new User(input.email(), input.username(), input.password());
  }

  public UserOutputDTO toOutput(User user) {
    return new UserOutputDTO(user.id(),
                              user.email(),
                              user.username(),
                              user.createdAt(),
                              user.updatedAt(),
                              user.userCourseIds());
  }
}
