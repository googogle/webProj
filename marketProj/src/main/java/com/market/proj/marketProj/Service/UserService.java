package com.market.proj.marketProj.Service;

import com.market.proj.marketProj.dto.UserDTO;
import com.market.proj.marketProj.Entity.User;
import com.market.proj.marketProj.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findByUserEmail(email);

        if(user == null) return null;
        else {
            return UserDTO.EntityTODto(user);
        }
    }

    public void saveUser(User user){
        userRepository.saveUser(user);
    }

    public void updateTokensByUserId(Long userId, String accessToken, String refreshToken) {
        userRepository.updateTokensByUserId(userId, accessToken, refreshToken);
    }

    public void deleteTokensByUserId(Long userId) {
        userRepository.deleteTokensByUserId(userId);
    }

    public String getAccessTokenByUserId(Long userId) {
       return userRepository.findAccessTokenByUserId(userId);
    }

    public User findUserEntityByIdx(Long userId) { return userRepository.findByIdx(userId); }


}
