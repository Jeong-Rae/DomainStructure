package domainstructure.domainstructure.application.user.controller;

import domainstructure.domainstructure.application.user.dto.UserRegisterRequest;
import domainstructure.domainstructure.application.user.service.UserRegisterService;
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
    public ResponseEntity<Void> register(@RequestBody UserRegisterRequest request) {
        userRegisterService.register(request);

        return ResponseEntity.ok().build();
    }
}
