package coursesystem.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.application.usecase.CreateUserUseCase;
import coursesystem.presentation.mapper.UserPresentationMapper;
import coursesystem.presentation.request.user.CreateUserRequestDTO;
import coursesystem.presentation.response.user.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
  private final UserPresentationMapper mapper;
  private final CreateUserUseCase createUserUseCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public UserResponseDTO createUser(@RequestBody @Valid CreateUserRequestDTO request) {
    CreateUserInputDTO input = this.mapper.toInput(request);
    UserOutputDTO output = this.createUserUseCase.execute(input);

    return this.mapper.toResponse(output);
  }
}
