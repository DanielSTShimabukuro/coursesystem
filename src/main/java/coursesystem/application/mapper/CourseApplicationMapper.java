package coursesystem.application.mapper;

import coursesystem.application.input.course.CreateCourseInputDTO;
import coursesystem.application.input.course.UpdateCourseInputDTO;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.model.course.Course;

public class CourseApplicationMapper {
  public Course toDomain(CreateCourseInputDTO input) {
    return new Course(input.name(), input.description(), input.price());
  }

  public Course update(Course course, UpdateCourseInputDTO input) {
    return new Course(course.id(), 
                      input.name(), 
                      input.description(), 
                      input.price(), 
                      course.createdAt(), 
                      course.userCourseIds());
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
