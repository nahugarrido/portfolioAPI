package com.portfoliov2.app.portfolioAPI.social.service;

import com.portfoliov2.app.portfolioAPI.social.entity.SocialEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISocialService {

    List<SocialEntity> getSocials();

    String saveSocial(Long user_id);

    String updateSocial(Long user_id, SocialEntity social);

}
