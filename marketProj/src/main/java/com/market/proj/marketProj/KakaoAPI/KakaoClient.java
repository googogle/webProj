package com.market.proj.marketProj.KakaoAPI;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Slf4j
@Component
public class KakaoClient {
    @Value("${kakaoAPI.url.login}")
    private String loginUrl;
    @Value("${kakaoAPI.url.redirect}")
    private String redirectUrl;
    @Value("${kakaoAPI.url.token}")
    private String getTokenUrl;
    @Value("${kakaoAPI.url.userinfo}")
    private String getUserInfoUrl;
    @Value("${kakaoAPI.url.logout}")
    private String logoutUrl;
    @Value("${kakaoAPI.client.key}")
    private String restKey;



    public String getToken(String code) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("client_id", restKey);
        map.add("redirect_uri", redirectUrl);
        map.add("code", code);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(getTokenUrl, entity, String.class);

        log.info("KakaoClient.getToken.token : {}", response);

        return response.getBody();
    }

    public JsonObject getUserKakaoAccount(String accessToken){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                getUserInfoUrl,
                HttpMethod.GET,
                entity,
                String.class
        );

        String responseBody = response.getBody();
        log.info("responseBody : {}", responseBody);
        JsonElement jsonElement = JsonParser.parseString(responseBody);
        log.info("jsonElement : {}", jsonElement);
        JsonObject kakao_account = jsonElement.getAsJsonObject().get("kakao_account").getAsJsonObject();

        return kakao_account;
    }

    public String getUserKakaoEmail(JsonObject kakao_account){
        return kakao_account.get("email").getAsString();
    }

    public String getUserKakaoNickname(JsonObject kakao_account){
        JsonObject kakao_profile = kakao_account.get("profile").getAsJsonObject();
        return kakao_profile.get("nickname").getAsString();
    }
    public Long getUserId(String accessToken){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                getUserInfoUrl,
                HttpMethod.GET,
                entity,
                String.class
        );

        String responseBody = response.getBody();
        JsonElement jsonElement = JsonParser.parseString(responseBody);
        Long userId = jsonElement.getAsJsonObject().get("id").getAsLong();
        return userId;
    }

    public String logout(String accessToken){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + accessToken);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                logoutUrl,
                HttpMethod.POST,
                entity,
                String.class
        );
        log.info("KakaoClient.logout.logout : {}", response.getBody());
        return response.getBody();
    }
}
