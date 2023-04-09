package com.example.begin.service;

import com.example.begin.dto.FoodResDto;
import com.example.begin.naverAPI.NaverClient;
import com.example.begin.naverAPI.dto.ImageSearchReqDTO;
import com.example.begin.naverAPI.dto.ImageSearchResDTO;
import com.example.begin.naverAPI.dto.LocalSearchReqDTO;
import com.example.begin.naverAPI.dto.LocalSearchResDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NaverService {

    private final NaverClient naverClient;
    public LocalSearchResDTO findLocalSearch(LocalSearchReqDTO reqDto){
        return naverClient.localSearch(reqDto);
    }

    public ImageSearchResDTO findImageSearch(ImageSearchReqDTO reqDto) { return naverClient.imageSearch(reqDto); }

    public FoodResDto search(String query) {
        var foodResDto = FoodResDto.builder().build();
        var localSearchDTO = LocalSearchReqDTO.builder()
                .query(query).build();
        var localResult = naverClient.localSearch(localSearchDTO);
        var optItem = localResult.getItems().stream().findFirst();

        if(optItem.isPresent()){
            var item = optItem.get();
            foodResDto.setTitle(item.getTitle());
            foodResDto.setAddress(item.getAddress());
            foodResDto.setCategory(item.getCategory());
            foodResDto.setRoadAddress(item.getRoadAddress());
            foodResDto.setHomepageLink(item.getLink());

            var imageSearchDTO = ImageSearchReqDTO.builder().query(item.getTitle()).build();
            var imageSearchResult  = naverClient.imageSearch(imageSearchDTO);
            var optImageItem = imageSearchResult.getItems().stream().findFirst();
            if(optImageItem.isPresent()) {
                foodResDto.setImageLink(optImageItem.get().getThumbnail());
            }
        }

        log.info("search result = {}", foodResDto);

        return foodResDto;
    }
}


