package coursesystem.presentation.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import coursesystem.application.input.course.CreateCourseInputDTO;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.presentation.request.course.CreateCourseRequestDTO;
import coursesystem.presentation.response.course.CourseResponseDTO;

@Component 
public class CoursePresentationMapper {
  public CreateCourseInputDTO toInput(CreateCourseRequestDTO request) {
    return new CreateCourseInputDTO(request.name(), request.description(), request.price(), request.userId());
  }

  public CourseResponseDTO toResponse(CourseOutputDTO output) {
    return new CourseResponseDTO(output.id(), 
                                  output.name(), 
                                  output.description(),
                                  output.price(), 
                                  output.userCourseIds());
  }
}
