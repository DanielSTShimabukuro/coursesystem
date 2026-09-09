package coursesystem.application.mapper;

import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.application.input.user.CreditBalanceUserInputDTO;
import coursesystem.application.input.user.UpdateUserInputDTO;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;

public class UserApplicationMapper {
  public User toDomain(CreateUserInputDTO input) {
    return new User(input.email(), input.username(), input.password());
  }

  public User update(User user, UpdateUserInputDTO input) {
    return new User(user.id(),
                    input.email(), 
                    input.username(), 
                    input.password(),
                    user.balance(),
                    user.createdAt(), 
                    user.updatedAt(), 
                    user.userCourseIds());
  }

  public User update(User user, CreditBalanceUserInputDTO input) {
    return new User(user.id(),
                    user.email(), 
                    user.username(), 
                    user.password(),
                    user.balance().add(input.amount()),
                    user.createdAt(), 
                    user.updatedAt(), 
                    user.userCourseIds());
  }

  public UserOutputDTO toOutput(User user) {
    return new UserOutputDTO(user.id(),
                              user.email(),
                              user.username(),
                              user.balance(),
                              user.createdAt(),
                              user.updatedAt(),
                              user.userCourseIds());
  }
}
