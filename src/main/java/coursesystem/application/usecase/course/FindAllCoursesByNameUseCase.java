package coursesystem.application.usecase.course;

import java.util.Set;
import java.util.stream.Collectors;

import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.repository.CourseRepository;

public class FindAllCoursesByNameUseCase {
  private final CourseApplicationMapper mapper;
  private final CourseRepository repository;

  public FindAllCoursesByNameUseCase(CourseApplicationMapper mapper, CourseRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public Set<CourseOutputDTO> execute(String name) {
    return this.repository.findAllByName(name).stream().map(course -> this.mapper.toOutput(course)).collect(Collectors.toSet());
  }
}
