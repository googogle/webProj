package com.market.proj.marketProj.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Transactional
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String categoryName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_idx")
    private Product product;
}
