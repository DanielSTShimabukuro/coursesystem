package coursesystem.domain.model.user;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserTest {
  private static final String VALID_EMAIL = "daniel.s.t.shimabukuro@gmail.com";
  private static final String VALID_USERNAME = "Daniel";
  private static final String VALID_PASSWORD = "Senha";

  @Test
  void shouldInstantiateUserWithValidData() {
    User user = this.buildUser(VALID_EMAIL, VALID_USERNAME, VALID_PASSWORD);

    assertAll(() -> assertEquals(VALID_EMAIL, user.email()),
              () -> assertEquals(VALID_USERNAME, user.username()),
              () -> assertEquals(VALID_PASSWORD, user.password()));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithNullEmail() {
    assertThrows(IllegalArgumentException.class, () -> this.buildUser(null, VALID_USERNAME, VALID_PASSWORD));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithInvalidEmail() {
    assertThrows(IllegalArgumentException.class, () -> this.buildUser("a".repeat(255), VALID_USERNAME, VALID_PASSWORD));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithNullUsername() {
    assertThrows(IllegalArgumentException.class, () -> this.buildUser(VALID_EMAIL, null, VALID_PASSWORD));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithBlankUsername() {
    assertThrows(IllegalArgumentException.class, () -> this.buildUser(VALID_EMAIL, " ", VALID_PASSWORD));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithNullPassword() {
    assertThrows(IllegalArgumentException.class, () -> this.buildUser(VALID_EMAIL, VALID_USERNAME, null));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserWithBlankPassword() {
    assertThrows(IllegalArgumentException.class, () -> this.buildUser(VALID_EMAIL, VALID_USERNAME, " "));
  } 

  private User buildUser(String email, String username, String password) {
    return new User(null,
                    email, 
                    username, 
                    password, 
                    null, 
                    null, 
                    null);
  }
}
