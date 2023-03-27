package com.portfoliov2.app.portfolioAPI.Interface;

import com.portfoliov2.app.portfolioAPI.Entity.Social;
import org.springframework.stereotype.Service;

@Service
public interface ISocialService {
    String updateSocial(Long user_id, Social social);

}
