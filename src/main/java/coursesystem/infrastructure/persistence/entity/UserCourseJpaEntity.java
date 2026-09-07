package coursesystem.infrastructure.persistence.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import coursesystem.domain.model.usercourse.CourseReaction;
import coursesystem.domain.model.usercourse.CourseStatus;
import coursesystem.domain.model.usercourse.UserType;
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
public class UserCourseJpaEntity {
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
  private UserJpaEntity user;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(nullable = false, name = "course_id", updatable = false)
  private CourseJpaEntity course;

  public UserCourseJpaEntity(UserType userType,
                              CourseStatus courseStatus,
                              CourseReaction courseReaction,
                              UserJpaEntity user,
                              CourseJpaEntity course)
  {
    this.userType = userType;
    this.courseStatus = courseStatus;
    this.courseReaction = courseReaction;
    this.user = user;
    this.course = course;
  }
}
