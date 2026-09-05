package coursesystem.presentation.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.application.input.user.UpdateUserInputDTO;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.application.usecase.CreateUserUseCase;
import coursesystem.application.usecase.FindUserByIdUseCase;
import coursesystem.application.usecase.UpdateUserUseCase;
import coursesystem.presentation.mapper.UserPresentationMapper;
import coursesystem.presentation.request.user.CreateUserRequestDTO;
import coursesystem.presentation.request.user.UpdateUserRequestDTO;
import coursesystem.presentation.response.user.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
  private final UserPresentationMapper mapper;
  private final CreateUserUseCase createUserUseCase;
  private final FindUserByIdUseCase findUserByIdUseCase;
  private final UpdateUserUseCase updateUserUseCase;

  @ResponseStatus(HttpStatus.CREATED) 
  @PostMapping
  public UserResponseDTO createUser(@RequestBody @Valid CreateUserRequestDTO request) {
    CreateUserInputDTO input = this.mapper.toInput(request);
    UserOutputDTO output = this.createUserUseCase.execute(input);

    return this.mapper.toResponse(output);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public UserResponseDTO findUserById(@PathVariable UUID id) {
    UserOutputDTO output = this.findUserByIdUseCase.execute(id);

    return this.mapper.toResponse(output);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/{id}")
  public UserResponseDTO updateUser(@PathVariable UUID id, @RequestBody @Valid UpdateUserRequestDTO request) {
    UpdateUserInputDTO input = this.mapper.toInput(request);
    UserOutputDTO output = this.updateUserUseCase.execute(id, input);

    return this.mapper.toResponse(output);
  }
}
