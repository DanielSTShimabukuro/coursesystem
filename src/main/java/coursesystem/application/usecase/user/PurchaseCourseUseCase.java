package coursesystem.application.usecase.user;

import java.util.UUID;

import coursesystem.application.exceptions.BusinessException;
import coursesystem.application.mapper.UserApplicationMapper;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.domain.repository.UserCourseRepository;
import coursesystem.domain.repository.UserRepository;

public class PurchaseCourseUseCase {
  private final UserApplicationMapper mapper;
  private final UserCourseRepository userCourseRepository;
  private final CourseRepository courseRepository;
  private final UserRepository repository;  

  public PurchaseCourseUseCase(UserApplicationMapper mapper,
                                UserCourseRepository userCourseRepository,
                                CourseRepository courseRepository,
                                UserRepository repository) {
    this.mapper = mapper;
    this.userCourseRepository = userCourseRepository;
    this.courseRepository = courseRepository;
    this.repository = repository;                                
  }

  private void validateCourse(UUID id, UUID courseId) {
    if(this.userCourseRepository.existsByUserIdAndCourseId(id, courseId)) throw new BusinessException("Course Already Purchased.");
  }
}
