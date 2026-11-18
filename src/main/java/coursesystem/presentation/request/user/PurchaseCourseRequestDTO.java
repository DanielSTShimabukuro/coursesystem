package coursesystem.presentation.request.user;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record PurchaseCourseRequestDTO(
  @NotNull UUID id,
  @NotNull UUID courseId
) {
  
}
