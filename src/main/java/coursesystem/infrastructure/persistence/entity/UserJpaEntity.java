  package coursesystem.infrastructure.persistence.entity;

  import java.math.BigDecimal;
import java.time.Instant;
  import java.util.HashSet;
  import java.util.Set;
  import java.util.UUID;

  import org.hibernate.annotations.CreationTimestamp;
  import org.hibernate.annotations.UpdateTimestamp;

  import jakarta.persistence.CascadeType;
  import jakarta.persistence.Column;
  import jakarta.persistence.Entity;
  import jakarta.persistence.FetchType;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
  import jakarta.persistence.OneToMany;
  import jakarta.persistence.Table;
  import jakarta.persistence.Version;
  import lombok.AccessLevel;
  import lombok.EqualsAndHashCode;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  import lombok.Setter;

  @Entity(name = "users")
  @Table(name = "users")
  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @EqualsAndHashCode(of = "id")
  public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    private Long version;

    @Setter
    @Column(nullable = false, length = 254, unique = true)
    private String email;

    @Setter
    @Column(nullable = false, length = 50, unique =  true)
    private String username;

    @Setter
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, precision = 8, scale = 2)
    private BigDecimal balance;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<UserCourseJpaEntity> usersCourses = new HashSet<>();

    public UserJpaEntity(String email,
                      String username,
                      String password,
                      BigDecimal balance) {
      this.email = email;
      this.username = username;
      this.password = password;
      this.balance = balance;
    }

    public void credit(BigDecimal amount) {
      this.validateAmount(amount);
      this.balance = this.balance.add(amount);
    }

    public void debit(BigDecimal amount) {
      this.validateAmount(amount);
      this.balance = this.balance.subtract(amount);
    }

    public void addUserCourse(UserCourseJpaEntity userCourse) {
      this.usersCourses.add(userCourse);
    }

    private void validateAmount(BigDecimal amount) {
      if (amount == null || amount.signum() <= 0 || amount.precision() > 8 || amount.scale() > 2) throw new IllegalArgumentException("Amount Invalid.");
    }
  }
