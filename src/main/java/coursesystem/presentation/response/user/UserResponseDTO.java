package coursesystem.presentation.response.user;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record UserResponseDTO(UUID id,
                              String email,
                              String username,
                              BigDecimal balance,
                              Instant createdAt,
                              Instant updatedAt,
                              Set<UUID> userCourseIds) {
  
}
