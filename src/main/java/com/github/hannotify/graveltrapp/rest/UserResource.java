package com.github.hannotify.graveltrapp.rest;

import com.github.hannotify.graveltrapp.dto.UserDto;
import com.github.hannotify.graveltrapp.persistence.beans.UserMapper;
import com.github.hannotify.graveltrapp.persistence.repositories.UserRepository;
import com.github.hannotify.graveltrapp.util.PasswordUtil;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.util.KeyUtils;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;
import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MINUTES;

@Path("/user")
@PermitAll
public class UserResource {
    private UserRepository userRepository;

    // CDI needs a no-args constructor
    UserResource() {}

    @Inject
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response register(UserDto user) {
        var userEntity = UserMapper.toEntity(user);
        userRepository.insert(userEntity);
        return Response.created(URI.create(userEntity.getId().toString())).build();
    }

    @POST
    @Path("/login")
    @Consumes(APPLICATION_JSON)
    public Response login(UserDto user) throws Exception {
        var userEntity = userRepository.findByUsernameAndPassword(user.username(), PasswordUtil.digest(user.password()));

        return userEntity.isPresent()
                ? Response.ok(issueToken(UserMapper.fromEntity(userEntity.get()))).build()
                : Response.status(UNAUTHORIZED).build();
    }

    private static String issueToken(UserDto userDto) throws GeneralSecurityException, IOException {
        return Jwt.issuer("http://localhost:9080/gravel-trapp")
                .subject("gravel-trapp")
                .upn(userDto.username())
                .claim("username", userDto.username())
                .groups(userDto.roles())
                .issuedAt(now())
                .expiresAt(now().plus(30, MINUTES))
                .sign(KeyUtils.readPrivateKey("META-INF/private-key.pem"));
    }
}

