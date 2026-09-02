package coursesystem.infrastructure.persistence.user;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;

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
  private UserJpaRepository repository;

  @Test
  void shouldPersistUserInDatabase() {
    UserJpaEntity user = new UserJpaEntity(VALID_EMAIL, VALID_USERNAME, VALID_PASSWORD);
    
    this.repository.saveAndFlush(user);
    assertAll(() -> assertNotNull(user.getId()),
              () -> assertEquals(0L, user.getVersion()),
              () -> assertNotNull(user.getCreatedAt()),
              () -> assertNotNull(user.getUpdatedAt()),
              () -> assertEquals(user.getCreatedAt(), user.getUpdatedAt()),
              () -> assertTrue(user.getUsersCourses().isEmpty()));
  }

  @Test
  void shouldUpdateUserInDatabase() {
    UserJpaEntity user = new UserJpaEntity(VALID_EMAIL, VALID_USERNAME, VALID_PASSWORD);

    this.repository.saveAndFlush(user);

    Long versionBefore = user.getVersion();
    Instant updatedAtBefore = user.getUpdatedAt();

    user.setEmail("email@gmail.com");
    this.repository.saveAndFlush(user);

    assertAll(() -> assertTrue(user.getVersion() > versionBefore),
              () -> assertNotEquals(VALID_EMAIL, user.getEmail()),
              () -> assertTrue(user.getUpdatedAt().isAfter(updatedAtBefore)));
  }

  @Test
  void shouldNotAllowNullEmailInDatabase() {
    UserJpaEntity user = new UserJpaEntity(null, VALID_USERNAME, VALID_PASSWORD);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user));
  }

  @Test
  void shouldNotAllowEmailWithInvalidLengthInDatabase() {
    UserJpaEntity user = new UserJpaEntity("a".repeat(255), VALID_USERNAME, VALID_PASSWORD);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user));
  }

  @Test
  void shouldNotAllowDuplicateEmailInDatabase() {
    UserJpaEntity user = new UserJpaEntity(VALID_EMAIL, VALID_USERNAME, VALID_PASSWORD);
    UserJpaEntity user2 = new UserJpaEntity(VALID_EMAIL, "DanielSTShimabukuro", "senha");

    this.repository.saveAndFlush(user);
    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user2));
  }

  @Test
  void shouldNotAllowNullUsernameInDatabase() {
    UserJpaEntity user = new UserJpaEntity(VALID_EMAIL, null, VALID_PASSWORD);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user));
  }

  @Test
  void shouldNotAllowUsernameWithInvalidLengthInDatabase() {
    UserJpaEntity user = new UserJpaEntity(VALID_EMAIL, "a".repeat(51), VALID_PASSWORD);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user));
  }

  @Test
  void shouldNotAllowDuplicateUsernameInDatabase() {
    UserJpaEntity user = new UserJpaEntity(VALID_EMAIL, VALID_USERNAME, VALID_PASSWORD);
    UserJpaEntity user2 = new UserJpaEntity("email@gmail.com", VALID_USERNAME, "senha");

    this.repository.saveAndFlush(user);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user2));
  }

  @Test
  void shouldNotAllowNullPasswordInDatabase() {
    UserJpaEntity user = new UserJpaEntity(VALID_EMAIL, VALID_USERNAME, null);

    assertThrows(DataIntegrityViolationException.class, () -> this.repository.saveAndFlush(user));
  }
}
