package coursesystem.presentation.response.user;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record UserResponseDTO(UUID id,
                              String email,
                              String username,
                              Instant createdAt,
                              Instant updatedAt,
                              Set<UUID> userCourseIds) {
  
}
