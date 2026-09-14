package coursesystem.application.usecase.course;

import java.util.Optional;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.course.UpdateCourseInputDTO;
import coursesystem.application.mapper.CourseApplicationMapper;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.domain.model.course.Course;
import coursesystem.domain.model.usercourse.UserCourse;
import coursesystem.domain.model.usercourse.UserType;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.domain.repository.UserCourseRepository;

public class UpdateCourseUseCase {
  private final CourseApplicationMapper mapper;
  private final UserCourseRepository userCourseRepository;
  private final CourseRepository repository;

  public UpdateCourseUseCase(CourseApplicationMapper mapper,
                              UserCourseRepository userCourseRepository,
                              CourseRepository repository) {
    this.mapper = mapper;
    this.userCourseRepository = userCourseRepository;
    this.repository = repository;
  }

  public CourseOutputDTO execute(UpdateCourseInputDTO input) {
    Course course = this.repository.findById(input.id()).orElseThrow(() -> new NotFoundException("Course Not Found."));

    this.validateUser(input);
    course = this.mapper.update(course, input);
    this.repository.save(course);

    return this.mapper.toOutput(course);
  }

  private void validateUser(UpdateCourseInputDTO input) {
    Optional<UserCourse> userCourse = this.userCourseRepository.findByUserIdAndCourseId(input.userId(), input.id());

    if (userCourse.isEmpty() || userCourse.get().userType() != UserType.OWNER) throw new BusinessException("Invalid User.");
  }
}
