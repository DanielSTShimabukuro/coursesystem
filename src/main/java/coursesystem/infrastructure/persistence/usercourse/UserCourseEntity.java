package coursesystem.infrastructure.persistence.usercourse;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import coursesystem.domain.entity.usercourse.CourseReaction;
import coursesystem.domain.entity.usercourse.CourseStatus;
import coursesystem.domain.entity.usercourse.UserType;
import coursesystem.infrastructure.persistence.course.CourseEntity;
import coursesystem.infrastructure.persistence.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users_courses")
@Table(name = "users_courses")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class UserCourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Version
  private Long version;

  @Setter
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private UserType userType;

  @Setter
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private CourseStatus courseStatus;

  @Setter
  @Enumerated(EnumType.STRING)
  private CourseReaction courseReaction;

  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private Instant createdAt;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(nullable = false, name = "user_id", updatable = false)
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(nullable = false, name = "course_id", updatable = false)
  private CourseEntity course;

  public UserCourseEntity(UserType userType,
                          CourseStatus courseStatus,
                          UserEntity user,
                          CourseEntity course)
  {
    this.userType = userType;
    this.courseStatus = courseStatus;
    this.user = user;
    this.course = course;
  }
}
