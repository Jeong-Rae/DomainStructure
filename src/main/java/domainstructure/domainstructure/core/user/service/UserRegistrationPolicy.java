package domainstructure.domainstructure.core.user.service;

import domainstructure.domainstructure.core.common.vo.Email;

public interface UserRegistrationPolicy {
    /**
     * 등록 가능한 이메일인지 확인합니다.
     *
     * @param email
     * @return 등록 가능 여부
     */
    boolean canRegisterWith(Email email);
}
