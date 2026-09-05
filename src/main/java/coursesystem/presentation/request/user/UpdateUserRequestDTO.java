package coursesystem.presentation.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserRequestDTO(@NotBlank @Size(max = 254) @Email String email, 
                                    @NotBlank @Size(max = 50, min = 3) String username, 
                                    @NotBlank @Size(max = 255, min = 8) String password) {
  
}
