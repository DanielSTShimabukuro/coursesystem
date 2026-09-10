package coursesystem.application.usecase.course;

import java.util.UUID;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.model.course.Course;
import coursesystem.domain.repository.CourseRepository;

public class FindByIdCourseUseCase {
  private final CourseApplicationMapper mapper;
  private final CourseRepository repository;

  public FindByIdCourseUseCase(CourseApplicationMapper mapper,
                                CourseRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public CourseOutputDTO execute(UUID id) {
    Course course = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Course Not Found."));

    return this.mapper.toOutput(course);
  }
}
