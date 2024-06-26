package com.skhuthon.caffeinebalance.user.dto.request;

import com.skhuthon.caffeinebalance.auth.dto.OAuth2Response;
import com.skhuthon.caffeinebalance.user.domain.Role;
import com.skhuthon.caffeinebalance.user.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateRequestDTO {
    @NotNull(message = "식별자은 null이 될 수 없습니다.")
    private String username;

    @NotNull(message = "이름은 null이 될 수 없습니다.")
    private String name;

    @NotNull(message = "이메일은 null이 될 수 없습니다.")
    private String email;

    @NotNull(message = "프로필 이미지는 null이 될 수 없습니다.")
    private String profile;

    @NotNull(message = "일일 권장 카페인양은 null이 될 수 없습니다.")
    private int recommendedCaffeineIntakeAmount;

    @NotNull(message = "오늘 먹은 카페인 양은 null이 될 수 없습니다.")
    private Double todayCaffeineIntakeAmount;

    @NotNull(message = "섭취 가능한 카페인 양은 null이 될 수 없습니다.")
    private Double canCaffeineIntakeAmount;

    @NotNull(message = "일일 권장 카페인 양은 null이 될 수 없습니다.")
    private double dailyRecommendedCaffeineAmount;

    public User toEntity() {
        return User.builder()
                .username(username)
                .name(name)
                .email(email)
                .role(Role.ROLE_USER)
                .profile(profile)
                .todayCaffeineIntakeAmount(todayCaffeineIntakeAmount)
                .canCaffeineIntakeAmount(canCaffeineIntakeAmount)
                .dailyRecommendedCaffeineAmount(dailyRecommendedCaffeineAmount)
                .build();
    }

    public static UserCreateRequestDTO fromOAuth2Response(OAuth2Response oAuth2Response, String username) {
        return UserCreateRequestDTO.builder()
                .username(username)
                .name(oAuth2Response.getName())
                .email(oAuth2Response.getEmail())
                .profile(oAuth2Response.getProfileImage())
                .todayCaffeineIntakeAmount(0D)
                .canCaffeineIntakeAmount(400D)
                .dailyRecommendedCaffeineAmount(400D)
                .build();
    }
}
