package coursesystem.application.output.user;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record UserOutputDTO(UUID id,
                            String email,
                            String username,
                            Instant createdAt,
                            Instant updatedAt,
                            Set<UUID> userCourseIds) {
  
}
