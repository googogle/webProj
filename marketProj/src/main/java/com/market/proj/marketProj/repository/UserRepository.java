package com.market.proj.marketProj.repository;

import com.market.proj.marketProj.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String email);
    default boolean saveUser(User user) {
        try {
            save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.accessToken = :accessToken, u.refreshToken = :refreshToken WHERE u.userId = :userId")
    void updateTokensByUserId(@Param("userId") Long userId, @Param("accessToken") String accessToken, @Param("refreshToken") String refreshToken);

    @Modifying
    @Query("UPDATE User u SET u.accessToken = NULL, u.refreshToken = NULL WHERE u.userId = :userId")
    void deleteTokensByUserId(@Param("userId") Long userId);

    @Query("SELECT u.accessToken FROM User u WHERE u.userId = :userId")
    String findAccessTokenByUserId(@Param("userId") Long userId);

    User findByIdx(Long idx);
}
