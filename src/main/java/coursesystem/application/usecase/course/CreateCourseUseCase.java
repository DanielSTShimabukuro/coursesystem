package coursesystem.application.usecase.course;

import java.util.UUID;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.course.CreateCourseInputDTO;
import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.model.course.Course;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.domain.repository.UserRepository;

public class CreateCourseUseCase {
  private final CourseApplicationMapper mapper;
  private final UserRepository userRepository;
  private final CourseRepository repository;

  public CreateCourseUseCase(CourseApplicationMapper mapper,
                              UserRepository userRepository,
                              CourseRepository repository) {
    this.mapper = mapper;
    this.userRepository = userRepository;
    this.repository = repository;
  }

  public CourseOutputDTO execute(UUID userId, CreateCourseInputDTO input) {
    this.validateCourse(userId);

    Course course = this.mapper.toDomain(input);

    course = this.repository.save(course, userId);

    return this.mapper.toOutput(course);
  }

  private void validateCourse(UUID userId) {
    if (!this.userRepository.existsById(userId)) throw new NotFoundException("User Not Found.");
  }
}
