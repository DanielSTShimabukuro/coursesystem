package coursesystem.application.usecase.course;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.course.UpdateCourseInputDTO;
import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.model.course.Course;
import coursesystem.domain.repository.CourseRepository;

public class UpdateCourseUseCase {
  private final CourseApplicationMapper mapper;
  private final CourseRepository repository;

  public UpdateCourseUseCase(CourseApplicationMapper mapper,
                              CourseRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public CourseOutputDTO execute(UpdateCourseInputDTO input) {
    Course course = this.repository.findById(input.id()).orElseThrow(() -> new NotFoundException("Course Not Found."));

    course = this.mapper.update(course, input);
    this.repository.save(course);

    return this.mapper.toOutput(course);
  }
}
