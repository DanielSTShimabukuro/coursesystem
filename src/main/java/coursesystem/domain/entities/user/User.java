package coursesystem.domain.entities.user;

public record User(String email,
                    String username,
                    String password) {
  public User {
    if (email == null || email.isBlank()) throw new IllegalArgumentException("Invalid Email.");

    if (username == null || username.isBlank()) throw new IllegalArgumentException("Invalid Username.");

    if (password == null || password.isBlank()) throw new IllegalArgumentException("Invalid Password.");
  }
}
