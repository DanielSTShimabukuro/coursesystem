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
                    Set<UUID> userCourseIds) {
  public User {
    if (email == null || email.length() > 254 || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9._]+\\.+[A-Za-z]{2,}$")) throw new IllegalArgumentException("Invalid Email.");

    if (username == null || username.length() > 50 || username.length() < 3 || username.isBlank()) throw new IllegalArgumentException("Invalid Username.");

    if (password == null || password.length() > 255 || password.length() < 8 || password.isBlank()) throw new IllegalArgumentException("Invalid Password.");
  }

  public User(String email,
              String username,
              String password) {
    this(null, email, username, password, null, null, null);
  }
}
