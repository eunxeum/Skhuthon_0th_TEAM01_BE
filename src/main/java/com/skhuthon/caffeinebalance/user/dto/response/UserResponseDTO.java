package com.skhuthon.caffeinebalance.user.dto.response;

import com.skhuthon.caffeinebalance.user.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDTO {
    private String username;

    private String name;

    private String email;;

    private String profile;

    private String role;

    public static UserResponseDTO fromEntity(User user) {
        return UserResponseDTO.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .profile(user.getProfile())
                .role(user.getRole().name())
                .build();
    }
    public static UserResponseDTO createFromJwt(String username, String role) {
        return UserResponseDTO.builder()
                .username(username)
                .name(username) // JWT에서 이름을 가져올 수 없는 경우, 사용자 이름을 대신 사용할 수 있음
                .role(role)
                .build();
    }
}
