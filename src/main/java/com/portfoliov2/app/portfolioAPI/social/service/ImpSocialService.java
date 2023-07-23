package com.portfoliov2.app.portfolioAPI.social.service;

import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioExceptions;
import com.portfoliov2.app.portfolioAPI.person.repository.PersonRepository;
import com.portfoliov2.app.portfolioAPI.social.entity.SocialEntity;
import com.portfoliov2.app.portfolioAPI.social.repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpSocialService implements ISocialService {

    @Autowired
    SocialRepository socialRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<SocialEntity> getSocials() {
        return socialRepository.findAll();
    }

    @Override
    public String saveSocial(Long user_id) {
        SocialEntity social = new SocialEntity();
        PersonEntity person = personRepository.findById(user_id).orElse(null);
        social.setPerson(person);
        //person.setSocial(social);

        personRepository.save(person);
        socialRepository.save(social);
        return "Saved social";
    }

    @Override
    public String updateSocial(Long user_id, SocialEntity social) {
        PersonEntity person = personRepository.findById(user_id).orElse(null);

        if(person == null) {
            throw new PortfolioExceptions("Person not found", HttpStatus.NOT_FOUND);
        }

        SocialEntity socialAux = person.getSocial();
        Long id = socialAux.getId();
        SocialEntity updatedSocial = socialRepository.getReferenceById(id);
        updatedSocial.setInstagram(social.getInstagram());
        updatedSocial.setGithub(social.getGithub());
        updatedSocial.setTwitter(social.getTwitter());
        updatedSocial.setLinkedin(social.getLinkedin());

        socialRepository.save(updatedSocial);
        return "Updated social information";
    }
}
