package domainstructure.domainstructure.infrastructure.user.repository;

import domainstructure.domainstructure.core.common.vo.Email;
import domainstructure.domainstructure.core.user.model.User;
import domainstructure.domainstructure.core.user.repository.UserRepository;
import domainstructure.domainstructure.infrastructure.user.entity.UserEntity;
import domainstructure.domainstructure.infrastructure.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toDomain(userJpaRepository.save(entity));
    }

    @Override
    public boolean existsByEmail(Email email) {
        return userJpaRepository.existsByEmail(email);
    }
}
