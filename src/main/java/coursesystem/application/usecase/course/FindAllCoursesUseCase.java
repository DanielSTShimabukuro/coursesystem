package coursesystem.application.usecase.course;

import java.util.Set;
import java.util.stream.Collectors;

import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.repository.CourseRepository;

public class FindAllCoursesUseCase {
  private final CourseApplicationMapper mapper;
  private final CourseRepository repository;

  public FindAllCoursesUseCase(CourseApplicationMapper mapper,
                                CourseRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public Set<CourseOutputDTO> execute() {
    return this.repository.findAll().stream().map(course -> this.mapper.toOutput(course)).collect(Collectors.toSet());
  }
}
