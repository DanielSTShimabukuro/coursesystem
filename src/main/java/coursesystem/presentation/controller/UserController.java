package coursesystem.presentation.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coursesystem.application.input.user.CreateUserInputDTO;
import coursesystem.application.input.user.CreditBalanceUserInputDTO;
import coursesystem.application.input.user.DebitBalanceUserInputDTO;
import coursesystem.application.input.user.UpdateUserInputDTO;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.application.usecase.user.CreateUserUseCase;
import coursesystem.application.usecase.user.CreditBalanceUserUseCase;
import coursesystem.application.usecase.user.DebitBalanceUserUseCase;
import coursesystem.application.usecase.user.DeleteUserUseCase;
import coursesystem.application.usecase.user.FindUserByIdUseCase;
import coursesystem.application.usecase.user.UpdateUserUseCase;
import coursesystem.presentation.mapper.UserPresentationMapper;
import coursesystem.presentation.request.user.CreateUserRequestDTO;
import coursesystem.presentation.request.user.CreditBalanceUserRequestDTO;
import coursesystem.presentation.request.user.DebitBalanceUserRequestDTO;
import coursesystem.presentation.request.user.UpdateUserRequestDTO;
import coursesystem.presentation.response.user.UserResponseDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
  private final UserPresentationMapper mapper;
  private final CreateUserUseCase createUserUseCase;
  private final FindUserByIdUseCase findUserByIdUseCase;
  private final UpdateUserUseCase updateUserUseCase;
  private final CreditBalanceUserUseCase creditBalanceUserUseCase;
  private final DebitBalanceUserUseCase debitBalanceUserUseCase;
  private final DeleteUserUseCase deleteUserUseCase;

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
  @PutMapping
  public UserResponseDTO updateUser(@RequestBody @Valid UpdateUserRequestDTO request) {
    UpdateUserInputDTO input = this.mapper.toInput(request);
    UserOutputDTO output = this.updateUserUseCase.execute(input);

    return this.mapper.toResponse(output);
  }

  @ResponseStatus(HttpStatus.OK)
  @PatchMapping("/credit")
  public UserResponseDTO creditBalanceUser(@RequestBody @Valid CreditBalanceUserRequestDTO request) {
    CreditBalanceUserInputDTO input = this.mapper.toInput(request);
    UserOutputDTO output = this.creditBalanceUserUseCase.execute(input);

    return this.mapper.toResponse(output);
  } 

  @ResponseStatus (HttpStatus.OK)
  @PatchMapping("/debit")
  public UserResponseDTO debitBalanceUser(@RequestBody @Valid DebitBalanceUserRequestDTO request) {
    DebitBalanceUserInputDTO input = this.mapper.toInput(request);
    UserOutputDTO output = this.debitBalanceUserUseCase.execute(input);

    return this.mapper.toResponse(output);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping
  public void deleteUser(@RequestBody @NotNull UUID id) {
    this.deleteUserUseCase.execute(id);
  }
}
