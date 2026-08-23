package coursesystem.domain.entities.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
  @Test
  void shouldInstantiateUserWithValidData() {
    String email = "daniel.s.t.shimabukuro@gmail.com";
    

    User user = new User("daniel.s.t.shimabukuro@gmail.com", "Daniel", "Senha");

    assertEquals("daniel.s.t.shimabukuro@gmail.com", user.email());
    assertEquals("Daniel", user.username());
    assertEquals("Senha", user.password());
  }  
}
