package com.spring.facebookfriend.service.Jwt;

import com.spring.facebookfriend.config.Jwt.TokenHandler;
import com.spring.facebookfriend.dtos.Jwt.UsersDto;
import com.spring.facebookfriend.mapper.UserMapper;
import com.spring.facebookfriend.model.jwt.Roles;
import com.spring.facebookfriend.model.jwt.Users;
import com.spring.facebookfriend.repo.RolesRepo;
import com.spring.facebookfriend.repo.UsersRepo;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {


  @Autowired
  private UsersRepo usersRepo;
  @Autowired
  private RolesRepo rolesRepo;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users getUserByEmail(String email) throws SystemException {

        Users user = usersRepo.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("error.invalid.email");
        }

        return user;
    }

    @Override
    public Users checkUserExistByToken(String token) {
        String email = tokenHandler.getSubject(token);

        if (Objects.isNull(email)) {
            return null;
        }

        return usersRepo.findByEmail(email);
    }

    @Override
    public void createUser(UsersDto usersDto) throws SystemException {

        if (usersDto.getId() != null) {
            throw new SystemException("id must be null");
        }

        Users userExists = usersRepo.findByEmail(usersDto.getEmail());
        if (userExists != null) {
            throw new RuntimeException("error.userExist");
        }

        Users user = UserMapper.USER_MAPPER.toEntity(usersDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Roles role = rolesRepo.findByCode("ROLE_USER");
        if (role == null) {
            throw new SystemException("role not exist");
        }

        List<Roles> roles = List.of(role);
        user.setRoles(roles);
        usersRepo.save(user);
    }

    @Override
    public UsersDto getUserById(Long id) {
        Users user = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.USER_MAPPER.toDto(user);
    }


}
