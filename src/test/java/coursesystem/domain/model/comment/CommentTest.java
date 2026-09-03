package coursesystem.domain.model.comment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CommentTest {
  private static final String VALID_CONTENT = "Content";

  @Test
  void shouldInstantiateCommentWithValidData() {
    Comment comment = new Comment(VALID_CONTENT);

    assertEquals(VALID_CONTENT, comment.content());
  }

  @Test 
  void shouldThrowExceptionWhenInstantiateWithNullContent() {
    assertThrows(IllegalArgumentException.class, () -> new Comment(null));
  }
}
