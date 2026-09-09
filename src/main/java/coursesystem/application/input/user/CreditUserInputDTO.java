package coursesystem.application.input.user;

import java.math.BigDecimal;
import java.util.UUID;

public record CreditUserInputDTO(UUID id,
                                  BigDecimal amount) {
  
}
