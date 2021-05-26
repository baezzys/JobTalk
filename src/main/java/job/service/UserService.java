package job.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import job.model.User;
import job.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}