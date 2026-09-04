package coursesystem.application.dto.input.user;

public record CreateUserInputDTO(String email, 
                                  String username, 
                                  String password) {
  
}
