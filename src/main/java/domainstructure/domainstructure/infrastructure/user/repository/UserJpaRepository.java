package domainstructure.domainstructure.infrastructure.user.repository;

import domainstructure.domainstructure.core.user.vo.UserID;
import domainstructure.domainstructure.infrastructure.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, UserID> {
}
