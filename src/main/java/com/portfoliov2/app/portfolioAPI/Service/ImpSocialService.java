package com.portfoliov2.app.portfolioAPI.Service;

import com.portfoliov2.app.portfolioAPI.Entity.Person;
import com.portfoliov2.app.portfolioAPI.Entity.Social;
import com.portfoliov2.app.portfolioAPI.Interface.ISocialService;
import com.portfoliov2.app.portfolioAPI.Repository.PersonRepository;
import com.portfoliov2.app.portfolioAPI.Repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpSocialService implements ISocialService {

    @Autowired
    SocialRepository socialRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public String updateSocial(Long user_id, Social social) {
        Person UpdatedPerson = personRepository.getReferenceById(user_id);
        UpdatedPerson.setSocial(social);
        return "Updated social information";
    }
}
