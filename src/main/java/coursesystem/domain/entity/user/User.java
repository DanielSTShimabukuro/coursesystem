package coursesystem.domain.entity.user;

public record User(String email,
                    String username,
                    String password) {
  public User {
    if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9._]+\\.+[A-Za-z]{2,}$")) throw new IllegalArgumentException("Invalid Email.");

    if (username == null || username.isBlank()) throw new IllegalArgumentException("Invalid Username.");

    if (password == null || password.isBlank()) throw new IllegalArgumentException("Invalid Password.");
  }
}
