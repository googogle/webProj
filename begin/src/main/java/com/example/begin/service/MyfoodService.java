package com.example.begin.service;

import com.example.begin.dto.MyFoodDto;
import com.example.begin.dto.ReviewDto;
import com.example.begin.entity.MyFood;
import com.example.begin.repository.MyFoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MyfoodService {
    private final MyFoodRepository myFoodRepository;
    public List<MyFoodDto> findMyFood(Long idx){
        var list = myFoodRepository.findByUserIdx(idx);
        List<MyFoodDto> myFoods = new ArrayList<>();

        if(list != null){
            list.get().forEach(f ->{
                myFoods.add(entityToDto(f));
            });
        }
        return myFoods;
    }

    public MyFoodDto entityToDto(MyFood myfood){
        var myFoodDto = MyFoodDto.builder().title(myfood.getTitle())
                .category(myfood.getCategory())
                .roadAddr(myfood.getRoadAddress())
                .idx(myfood.getIdx())
                .build();
        return myFoodDto;
    }

    public void deleteMyFood(Long idx){
        myFoodRepository.deleteByIdx(idx);
    }

    public void addmyfood(MyFood mf){
        myFoodRepository.save(mf);
    }

}
