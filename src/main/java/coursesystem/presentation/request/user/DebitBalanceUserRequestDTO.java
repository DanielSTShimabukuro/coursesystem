package coursesystem.presentation.request.user;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DebitBalanceUserRequestDTO(@NotNull UUID id,
                                          @NotNull @Positive @Digits(integer = 6, fraction = 2) BigDecimal amount) {
  
}
