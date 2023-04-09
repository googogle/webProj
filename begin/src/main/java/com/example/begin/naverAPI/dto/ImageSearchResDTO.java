package com.example.begin.naverAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageSearchResDTO {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<Item> items;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;

    }

}
