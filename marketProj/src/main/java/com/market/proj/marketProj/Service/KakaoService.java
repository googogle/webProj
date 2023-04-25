package com.market.proj.marketProj.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.market.proj.marketProj.KakaoAPI.KakaoClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class KakaoService {
    private final KakaoClient kakaoClient;

    public Map<String,Object> getAccessTokenAndRefreshToken(String code) {
        String res = kakaoClient.getToken(code);
        JsonElement element = JsonParser.parseString(res);
        String accessToken = element.getAsJsonObject().get("access_token").getAsString();
        log.info("kakoService.getAccessToken access: {}", accessToken);
        String refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
        log.info("kakoService.getAccessToken refresh: {}", refreshToken);
        Map<String,Object> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        return tokens;
    }

    public JsonObject getUserKakaoAccount(String accessToken) {
        return kakaoClient.getUserKakaoAccount(accessToken);
    }

    public String getUserKakaoEmail(JsonObject kakao_account) {
        return kakaoClient.getUserKakaoEmail(kakao_account);
    }

    public String getUserKakaoNickname(JsonObject kakao_account) {
        return kakaoClient.getUserKakaoNickname(kakao_account);
    }

    public Long getUserKakaoId(String accessToken) { return kakaoClient.getUserId(accessToken);}

    public Long logout(String accessToken) {
        String resBody = kakaoClient.logout(accessToken);
        JsonElement jsonElement = JsonParser.parseString(resBody);
        Long userId = jsonElement.getAsJsonObject().get("id").getAsLong();
        return userId;
    }

}
