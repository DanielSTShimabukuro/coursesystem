package coursesystem.presentation.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import coursesystem.application.input.course.CreateCourseInputDTO;
import coursesystem.presentation.request.course.CreateCourseRequestDTO;

@Component 
public class CoursePresentationMapper {
  public CreateCourseInputDTO toInput(CreateCourseRequestDTO request, UUID userId) {
    return new CreateCourseInputDTO(request.name(), request.description(), request.price(), userId);
  }
}
