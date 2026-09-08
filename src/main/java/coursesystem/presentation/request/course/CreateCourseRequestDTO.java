package coursesystem.presentation.request.course;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateCourseRequestDTO(@NotBlank @Size(max = 150, min = 2)  String name,
                                      @NotBlank @Size(max = 1000, min = 10) String description,
                                      @NotNull @PositiveOrZero @Digits(integer = 6, fraction = 2) BigDecimal price) {
  
}
