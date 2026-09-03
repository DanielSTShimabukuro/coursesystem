package coursesystem.domain.model.comment;

public record Comment(String content) {
  public Comment {
    if (content == null || content.isBlank()) throw new IllegalArgumentException("Invalid Content.");
  }
}
