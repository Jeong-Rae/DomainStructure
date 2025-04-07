package domainstructure.domainstructure.application.user.controller;

import domainstructure.domainstructure.application.user.dto.UserRegisterRequest;
import domainstructure.domainstructure.application.user.dto.UserResponse;
import domainstructure.domainstructure.application.user.service.UserRegisterService;
import domainstructure.domainstructure.core.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRegisterService userRegisterService;

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody UserRegisterRequest request) {
        User user = userRegisterService.register(request);

        return ResponseEntity.ok(UserResponse.of(user));
    }
}
