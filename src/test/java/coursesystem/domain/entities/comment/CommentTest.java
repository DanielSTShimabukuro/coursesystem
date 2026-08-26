package coursesystem.domain.entities.comment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommentTest {
  private static final String VALID_CONTENT = "Content";

  @Test
  void shouldInstantiateCommentWithValidData() {
    Comment comment = new Comment(VALID_CONTENT);

    assertEquals(VALID_CONTENT, comment.content());
  }
}
