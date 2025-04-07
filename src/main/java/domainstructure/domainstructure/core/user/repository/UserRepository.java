package domainstructure.domainstructure.core.user.repository;

import domainstructure.domainstructure.core.user.model.User;

public interface UserRepository {
    /**
     * User 객체 저장 후 저장된 User 객체 반환
     *
     * @param user 저장할 User 객체
     * @return 저장된 User 객체
     */
    User save(User user);
}
