package coursesystem.domain.entities.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UserTest {
  @Test
  void shouldInstantiateUserWithValidData() {
    String email = "daniel.s.t.shimabukuro@gmail.com";
    String name = "Daniel";
    String password = "Senha";
    

    User user = new User(email, name, password);

    assertEquals(email, user.email());
    assertEquals(name, user.username());
    assertEquals(password, user.password());
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithNullEmail() {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new User(null, "Daniel", "Senha"));

    assertEquals("Invalid Email.", ex.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithBlankEmail() {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new User("", "Daniel", "Senha"));

    assertEquals("Invalid Email.", ex.getMessage());
  }
}
