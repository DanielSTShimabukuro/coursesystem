package coursesystem.application.usecase.course;

import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.domain.repository.CourseRepository;

public class FindAllCoursesByNameUseCase {
  private final CourseApplicationMapper mapper;
  private final CourseRepository repository;

  public FindAllCoursesByNameUseCase(CourseApplicationMapper mapper, CourseRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }
}
