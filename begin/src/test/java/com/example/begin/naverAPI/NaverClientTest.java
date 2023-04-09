package com.example.begin.naverAPI;

import com.example.begin.naverAPI.dto.ImageSearchReqDTO;
import com.example.begin.naverAPI.dto.LocalSearchReqDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NaverClientTest {
    @Autowired
    NaverClient naverClient;

    @Test
    void uriMakeStrTest(){
        var searchDTO = LocalSearchReqDTO.builder().query("삼겹살").build();
        naverClient.localSearch(searchDTO);
    }

    @Test
    void imageSearchTest(){
        var searchDTO = ImageSearchReqDTO.builder().query("삼겹살").build();
        naverClient.imageSearch(searchDTO);
    }


}