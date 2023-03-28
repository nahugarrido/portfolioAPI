package com.portfoliov2.app.portfolioAPI.Service;

import com.portfoliov2.app.portfolioAPI.Entity.Person;
import com.portfoliov2.app.portfolioAPI.Entity.Social;
import com.portfoliov2.app.portfolioAPI.Interface.ISocialService;
import com.portfoliov2.app.portfolioAPI.Repository.PersonRepository;
import com.portfoliov2.app.portfolioAPI.Repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpSocialService implements ISocialService {

    @Autowired
    SocialRepository socialRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Social> getSocials() {
        return socialRepository.findAll();
    }

    @Override
    public String saveSocial(Long user_id) {
        Social social = new Social();
        Person person = personRepository.findById(user_id).orElse(null);
        social.setPerson(person);
        //person.setSocial(social);
        personRepository.save(person);
        socialRepository.save(social);
        return "Saved social";
    }

    @Override
    public String updateSocial(Long user_id, Social social) {
        Person UpdatedPerson = personRepository.getReferenceById(user_id);
        UpdatedPerson.setSocial(social);
        return "Updated social information";
    }
}
