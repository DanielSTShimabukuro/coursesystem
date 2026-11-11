package coursesystem.application.usecase.user;

import java.util.UUID;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.UserOutputDTO;
import coursesystem.domain.model.user.User;
import coursesystem.domain.model.usercourse.CourseReaction;
import coursesystem.domain.model.usercourse.CourseStatus;
import coursesystem.domain.model.usercourse.UserCourse;
import coursesystem.domain.model.usercourse.UserType;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.domain.repository.UserCourseRepository;
import coursesystem.domain.repository.UserRepository;

public class PurchaseCourseUseCase {
  private final UserApplicationMapper mapper;
  private final UserCourseRepository userCourseRepository;
  private final CourseRepository courseRepository;
  private final UserRepository repository;  

  public PurchaseCourseUseCase(
    UserApplicationMapper mapper,
    UserCourseRepository userCourseRepository,
    CourseRepository courseRepository,
    UserRepository repository
  ) {
    this.mapper = mapper;
    this.userCourseRepository = userCourseRepository;
    this.courseRepository = courseRepository;
    this.repository = repository;                                
  }

  public UserOutputDTO execute(UUID id, UUID courseId) {
    this.validate(id, courseId);

    UserCourse userCourse = new UserCourse(UserType.CLIENT, CourseStatus.NOT_STARTED, CourseReaction.NONE, id, courseId);

    this.userCourseRepository.save(userCourse);

    User user = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found."));

    return this.mapper.toOutput(user);
  }

  private void validate(UUID id, UUID courseId) {
    if (!this.repository.existsById(id)) throw new NotFoundException("User Not Found.");

    if(!this.courseRepository.existsById(courseId)) throw new NotFoundException("Course Not Found.");

    if (this.userCourseRepository.existsByUserIdAndCourseId(id, courseId)) throw new BusinessException("Course Already Purchased.");
  }
}
