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
    assertThrows(IllegalArgumentException.class, () -> new User(null, "Daniel", "Senha"));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithBlankEmail() {
    assertThrows(IllegalArgumentException.class, () -> new User(" ", "Daniel", "Senha"));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithNullUsername() {
    assertThrows(IllegalArgumentException.class, () -> new User("daniel.s.t.shimabukuro@gmail.com", null, "Senha"));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithBlankUsername() {
    assertThrows(IllegalArgumentException.class, () -> new User("daniel.s.t.shimabukuro@gmail.com", " ", "Senha"));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithNullPassword() {
    assertThrows(IllegalArgumentException.class, () -> new User("daniel.s.t.shimabukuro@gmail.com", "Daniel", null));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithBlankPassword() {
    assertThrows(IllegalArgumentException.class, () -> new User("daniel.s.t.shimabukuro@gmail.com", "Daniel", " "));
  } 
}
