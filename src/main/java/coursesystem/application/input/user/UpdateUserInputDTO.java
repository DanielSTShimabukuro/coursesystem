package coursesystem.application.input.user;

import java.util.UUID;

public record UpdateUserInputDTO(UUID id,
                                  String email, 
                                  String username, 
                                  String password) {
  
}
