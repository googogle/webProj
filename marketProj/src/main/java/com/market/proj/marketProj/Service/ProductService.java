package com.market.proj.marketProj.Service;

import com.market.proj.marketProj.Entity.Bidding;
import com.market.proj.marketProj.Entity.Category;
import com.market.proj.marketProj.Entity.Product;
import com.market.proj.marketProj.Entity.User;
import com.market.proj.marketProj.dto.ProductDTO;
import com.market.proj.marketProj.dto.UserDTO;
import com.market.proj.marketProj.repository.CategoryRepository;
import com.market.proj.marketProj.repository.ProductRepository;
import com.market.proj.marketProj.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    public String saveProductImage(MultipartFile image){
        String imageFolder = "D:\\productImages";
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        String originalFileName = image.getOriginalFilename();
        String[] ext = originalFileName.split("\\.");
        String imageExtension = ext[ext.length - 1];
        String saveImageName = generatedString+"."+imageExtension;
        String finalSaveImagePath = imageFolder + "\\" + saveImageName;

        File saveFile = new File(finalSaveImagePath);
        try {
            image.transferTo(saveFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("ProductService: ProductImagePath : {}", finalSaveImagePath);
        return finalSaveImagePath;
    }

    public Product saveProduct(List<String> categories, Map<String,Object> data, MultipartFile image, UserDTO userDto) {
        String imagePath = saveProductImage(image).replace("\\" , "/");
        String[] tmp = imagePath.split(":");
        String img = tmp[1];
        String userEmail = userDto.getUserEmail();
        LocalDateTime endTime = LocalDateTime.parse(data.get("end_time").toString());
        User itemOwner = userRepository.findByUserEmail(userEmail);
        Product product = Product.builder().productName(data.get("item_name").toString())
                .user(itemOwner)
                .endTime(endTime)
                .productDescription(data.get("item_description").toString())
                .productStartingPrice(data.get("start_price").toString())
                .productTickPrice(data.get("tick_price").toString())
                .productImage(img)
                .build();
        Product savedProduct = productRepository.save(product);
        Long productIdx = savedProduct.getIdx();
        for(String category : categories){
            category = category.replaceAll("[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\s]", "");
            log.info("category : {}" , category);
            Category cat = Category.builder()
                    .product(savedProduct)
                    .categoryName(category)
                    .build();
            categoryRepository.save(cat);
        }
        return savedProduct;
    }

    public ProductDTO findProductDTOById(Long idx){
        Product product = productRepository.findById(idx).get();
        ProductDTO productDto = ProductDTO.EntityTODto(product);

        return productDto;
    }

    public Product findProductEntityById(Long idx){
        return productRepository.findByIdx(idx);
    }

    public void save(Product product) { productRepository.save(product); }

    public List<Product> findByIsEndFalse() { return productRepository.findByIsEndFalse(); }

    public List<Product> findFirst12ByOrderByCreatedAtDesc() { return productRepository.findFirst12ByOrderByCreatedAtDesc(); }

    public List<Product> findFirst12ByIsEndFalseOrderByCreatedAtDesc() { return productRepository.findFirst12ByIsEndFalseOrderByCreatedAtDesc(); }

    public int getProductTopPrice(Long idx){
        Product product = productRepository.findByIdx(idx);
        List<Bidding> biddingList = product.getProductBidded();
        if(biddingList == null) return 0;
        int topPrice = 0;
        for(Bidding b : biddingList){
            if(b.getBiddingPrice() > topPrice) topPrice = b.getBiddingPrice();
        }
        return topPrice;
    }
}
