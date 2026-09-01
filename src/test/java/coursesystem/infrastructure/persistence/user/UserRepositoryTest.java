package coursesystem.infrastructure.persistence.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
  private static final String VALID_EMAIL = "daniel.s.t.shimabukuro@gmail.com";
  private static final String VALID_USERNAME = "Daniel";
  private static final String VALID_PASSWORD = "Senha";

  @Autowired
  private UserRepository repository;

  @Test
  void shouldNotAllowNullEmailInDatabase() {
    UserEntity user = new UserEntity(null, VALID_USERNAME, VALID_PASSWORD);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user));
  }

  @Test
  void shouldNotAllowEmailWithInvalidLengthInDatabase() {
    UserEntity user = new UserEntity("a".repeat(255), VALID_USERNAME, VALID_PASSWORD);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user));
  }
}
