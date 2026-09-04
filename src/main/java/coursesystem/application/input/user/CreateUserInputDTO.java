package coursesystem.application.input.user;

public record CreateUserInputDTO(String email, 
                                  String username, 
                                  String password) {
  
}
