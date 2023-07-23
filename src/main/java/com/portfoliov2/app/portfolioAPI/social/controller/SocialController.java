package com.portfoliov2.app.portfolioAPI.social.controller;

import com.portfoliov2.app.portfolioAPI.social.entity.SocialEntity;
import com.portfoliov2.app.portfolioAPI.social.service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/social")
public class SocialController {
    @Autowired
    ISocialService iSocialService;

    @GetMapping
    public List<SocialEntity> getSocials() {
        return iSocialService.getSocials();
    }

    @PutMapping(value = "/update/{id}")
    public String updateSocial(@PathVariable Long id, @RequestBody SocialEntity social) {
       return iSocialService.updateSocial(id, social);
    }

}
