package coursesystem.application.input.user;

import java.math.BigDecimal;
import java.util.UUID;

public record CreditBalanceUserInputDTO(UUID id,
                                  BigDecimal amount) {
  
}
