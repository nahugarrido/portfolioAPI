package com.portfoliov2.app.portfolioAPI.Controller;

import com.portfoliov2.app.portfolioAPI.Entity.Social;
import com.portfoliov2.app.portfolioAPI.Interface.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialController {
    @Autowired
    ISocialService iSocialService;

    @PutMapping(value = "/social/{id}")
    public String updateSocial(@PathVariable Long id, @RequestBody Social social) {
       return iSocialService.updateSocial(id, social);
    }

}
