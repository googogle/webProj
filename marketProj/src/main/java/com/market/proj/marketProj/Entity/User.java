package com.market.proj.marketProj.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private Long userId;
    private String userNickname;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String accessToken;
    private String refreshToken;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Bidding> userBidded = new ArrayList<>();
    @ToString.Exclude
    @OneToOne(mappedBy = "user")
    private Address address;
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Product> userProducts = new ArrayList<>();

}
