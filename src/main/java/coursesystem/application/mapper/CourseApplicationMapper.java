package coursesystem.application.mapper;

import coursesystem.application.input.course.CreateCourseInputDTO;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.model.course.Course;

public class CourseApplicationMapper {
  public Course toDomain(CreateCourseInputDTO input) {
    return new Course(input.name(), input.description(), input.price());
  }

  public CourseOutputDTO toOutput(Course course) {
    return new CourseOutputDTO(course.id(), 
                                course.name(),
                                course.description(), 
                                course.price(), 
                                course.createdAt(),
                                course.userCourseIds());   
  }
}
