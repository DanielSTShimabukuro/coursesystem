package coursesystem.application.usecase.user;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.exceptions.NotFoundException;
import coursesystem.application.input.user.DebitBalanceUserInputDTO;
import coursesystem.application.input.user.PurchaseCourseInputDTO;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.application.output.user.PurchaseCourseOutputDTO;
import coursesystem.domain.model.course.Course;
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

  public PurchaseCourseOutputDTO execute(PurchaseCourseInputDTO input) {
    if (this.userCourseRepository.existsByUserIdAndCourseId(input.id(), input.courseId())) throw new BusinessException("Course Already Purchased");

    this.debitUser(input);

    UserCourse userCourse = new UserCourse(UserType.CLIENT, CourseStatus.NOT_STARTED, CourseReaction.NONE, input.id(), input.courseId());

    this.userCourseRepository.save(userCourse);

    return new PurchaseCourseOutputDTO(userCourse.id(), userCourse.courseId(), userCourse.userType());
  }
  
  private void debitUser(PurchaseCourseInputDTO input) {
    User user = this.repository.findById(input.id()).orElseThrow(() -> new NotFoundException("User Not Found."));
    Course course = this.courseRepository.findById(input.courseId()).orElseThrow(() -> new NotFoundException("Course Not Found."));
    
    if (user.balance().compareTo(course.price()) < 0) throw new BusinessException("Balance Insuficient");

    DebitBalanceUserInputDTO debitBalanceUserInputDTO = new DebitBalanceUserInputDTO(user.id(), course.price());
    
    user = this.mapper.update(user, debitBalanceUserInputDTO);
    this.repository.save(user);
  }
}
