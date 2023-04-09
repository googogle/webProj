package com.example.begin.naverAPI;

import com.example.begin.naverAPI.dto.ImageSearchReqDTO;
import com.example.begin.naverAPI.dto.ImageSearchResDTO;
import com.example.begin.naverAPI.dto.LocalSearchReqDTO;
import com.example.begin.naverAPI.dto.LocalSearchResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class NaverClient {
    @Value("${naverAPI.client.id}")
    private String naverClientId;
    @Value("${naverAPI.client.secret}")
    private String naverApiSecret;
    @Value("${naverAPI.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naverAPI.url.search.image}")
    private String naverImageSearchUrl;

    public LocalSearchResDTO localSearch(LocalSearchReqDTO localSearchReqDTO){
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParams(localSearchReqDTO.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        log.info("uri = {}", uri.toString());

        var headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", naverClientId);
        headers.add("X-Naver-Client-Secret", naverApiSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = RequestEntity.get(uri)
                .headers(headers).build();

        var responseResult = new RestTemplate().exchange(httpEntity,
                new ParameterizedTypeReference<LocalSearchResDTO>(){});

        log.info("response result = {}", responseResult.getBody());

        return responseResult.getBody();
    }

    public ImageSearchResDTO imageSearch(ImageSearchReqDTO imageSearchReqDTO){
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
                .queryParams(imageSearchReqDTO.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        log.info("uri = {}", uri.toString());

        var headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", naverClientId);
        headers.add("X-Naver-Client-Secret", naverApiSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = RequestEntity.get(uri)
                .headers(headers).build();

        var responseResult = new RestTemplate().exchange(httpEntity,
                new ParameterizedTypeReference<ImageSearchResDTO>(){});

        log.info("response result = {}", responseResult.getBody());

        return responseResult.getBody();
    }
}
