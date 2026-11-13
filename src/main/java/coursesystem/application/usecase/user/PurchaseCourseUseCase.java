package coursesystem.application.usecase.user;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.user.PurchaseCourseInputDTO;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.PurchaseCourseOutputDTO;
import coursesystem.domain.model.usercourse.CourseReaction;
import coursesystem.domain.model.usercourse.CourseStatus;
import coursesystem.domain.model.usercourse.UserCourse;
import coursesystem.domain.model.usercourse.UserType;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.domain.repository.UserCourseRepository;
import coursesystem.domain.repository.UserRepository;

public class PurchaseCourseUseCase {
  private final UserCourseRepository userCourseRepository;
  private final CourseRepository courseRepository;
  private final UserRepository repository;

  public PurchaseCourseUseCase(
    UserApplicationMapper mapper,
    UserCourseRepository userCourseRepository,
    CourseRepository courseRepository,
    UserRepository repository
  ) {
    this.userCourseRepository = userCourseRepository;
    this.courseRepository = courseRepository;
    this.repository = repository;
  }

  public PurchaseCourseOutputDTO execute(PurchaseCourseInputDTO input) {
    this.validate(input);

    UserCourse userCourse = new UserCourse(UserType.CLIENT, CourseStatus.NOT_STARTED, CourseReaction.NONE, input.id(), input.courseId());

    this.userCourseRepository.save(userCourse);

    return new PurchaseCourseOutputDTO(userCourse.id(), userCourse.courseId(), userCourse.userType());
  }

  private void validate(PurchaseCourseInputDTO input) {
    if (!this.repository.existsById(input.id())) throw new NotFoundException("User Not Found.");

    if (!this.courseRepository.existsById(input.courseId())) throw new NotFoundException("Course Not Found.");

    if (this.userCourseRepository.existsByUserIdAndCourseId(input.id(), input.courseId())) throw new BusinessException("Course Already Purchased.");
  }
}
