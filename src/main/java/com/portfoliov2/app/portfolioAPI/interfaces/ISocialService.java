package com.portfoliov2.app.portfolioAPI.interfaces;

import com.portfoliov2.app.portfolioAPI.entity.Social;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISocialService {

    List<Social> getSocials();

    String saveSocial(Long user_id);

    String updateSocial(Long user_id, Social social);

}
