package com.portfoliov2.app.portfolioAPI.controller;

import com.portfoliov2.app.portfolioAPI.entity.Social;
import com.portfoliov2.app.portfolioAPI.interfaces.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    ISocialService iSocialService;

    @GetMapping(value = "/social")
    public List<Social> getSocials() {
        return iSocialService.getSocials();
    }

    @PutMapping(value = "/social/update/{id}")
    public String updateSocial(@PathVariable Long id, @RequestBody Social social) {
       return iSocialService.updateSocial(id, social);
    }

}
