package com.skhuthon.caffeinebalance.auth.dto;

import com.skhuthon.caffeinebalance.global.exception.CustomException;
import com.skhuthon.caffeinebalance.global.exception.ErrorCode;
import java.util.Map;

public class NaverResponse implements OAuth2Response {
    private static final String RESPONSE_KEY = "response";
    private static final String ID_KEY = "id";
    private static final String EMAIL_KEY = "email";
    private static final String NAME_KEY = "name";
    private static final String PROFILE_IMAGE_KEY = "profile_image";

    private final Map<String, Object> attribute;

    public NaverResponse(Map<String, Object> attribute) {
        this.attribute = castToMap(attribute.get(RESPONSE_KEY));
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getProviderId() {
        return attribute.get(ID_KEY).toString();
    }

    @Override
    public String getEmail() {
        return attribute.get(EMAIL_KEY).toString();
    }

    @Override
    public String getName() {
        return attribute.get(NAME_KEY).toString();
    }

    @Override
    public String getProfileImage() {
        return attribute.get(PROFILE_IMAGE_KEY).toString();
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> castToMap(Object obj) {
        if (obj instanceof Map) {
            return (Map<String, Object>) obj;
        } else {
            throw new CustomException(ErrorCode.INVALID_ATTRIBUTE_TYPE_MESSAGE);
        }
    }
}
