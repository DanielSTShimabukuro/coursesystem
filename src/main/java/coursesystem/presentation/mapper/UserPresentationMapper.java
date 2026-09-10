package coursesystem.presentation.mapper;

import org.springframework.stereotype.Component;

import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.application.input.user.CreditBalanceUserInputDTO;
import coursesystem.application.input.user.DebitBalanceUserInputDTO;
import coursesystem.application.input.user.UpdateUserInputDTO;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.presentation.request.user.CreateUserRequestDTO;
import coursesystem.presentation.request.user.CreditBalanceUserRequestDTO;
import coursesystem.presentation.request.user.DebitBalanceUserRequestDTO;
import coursesystem.presentation.request.user.UpdateUserRequestDTO;
import coursesystem.presentation.response.user.UserResponseDTO;

@Component 
public class UserPresentationMapper {
  public CreateUserInputDTO toInput(CreateUserRequestDTO request) {
    return new CreateUserInputDTO(request.email(), request.username(), request.password());
  }

  public UpdateUserInputDTO toInput(UpdateUserRequestDTO request) {
    return new UpdateUserInputDTO(request.id(), request.email(), request.username(), request.password());
  }

  public CreditBalanceUserInputDTO toInput(CreditBalanceUserRequestDTO request) {
    return new CreditBalanceUserInputDTO(request.id(), request.amount());
  }

  public DebitBalanceUserInputDTO toInput(DebitBalanceUserRequestDTO request) {
    return new DebitBalanceUserInputDTO(request.id(), request.amount());
  }

  public UserResponseDTO toResponse(UserOutputDTO output) {
    return new UserResponseDTO(output.id(),
                              output.email(),
                              output.username(),
                              output.balance(),
                              output.createdAt(),
                              output.updatedAt(),
                              output.userCourseIds());
  }
}
