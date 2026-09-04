package coursesystem.domain.model.user;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record User(UUID id,
                    String email,
                    String username,
                    String password,
                    Instant createdAt,
                    Instant updatedAt,
                    Set<UUID> usersCoursesIds) {
  public User {
    if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9._]+\\.+[A-Za-z]{2,}$")) throw new IllegalArgumentException("Invalid Email.");

    if (username == null || username.isBlank()) throw new IllegalArgumentException("Invalid Username.");

    if (password == null || password.isBlank()) throw new IllegalArgumentException("Invalid Password.");
  }
}
