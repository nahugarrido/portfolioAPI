package com.portfoliov2.app.portfolioAPI.experience.service;

import com.portfoliov2.app.portfolioAPI.experience.dto.ExperienceDTO;
import com.portfoliov2.app.portfolioAPI.experience.dto.ExperienceSaveDTO;
import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import com.portfoliov2.app.portfolioAPI.experience.repository.ExperienceRepository;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioException;
import com.portfoliov2.app.portfolioAPI.person.service.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImpExperienceService implements IExperienceService {

    private final ExperienceRepository experienceRepository;

    private final IPersonService iPersonService;

    private final ModelMapper modelMapper;

    public ImpExperienceService(ExperienceRepository experienceRepository, IPersonService iPersonService, ModelMapper modelMapper) {
        this.experienceRepository = experienceRepository;
        this.iPersonService = iPersonService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ExperienceDTO> getExperiences() {
        List<ExperienceEntity> entityList = experienceRepository.findAll();

        List<ExperienceDTO> dtoList = new ArrayList<>();

        for(ExperienceEntity item : entityList) {
            ExperienceDTO aux = modelMapper.map(item, ExperienceDTO.class);
            dtoList.add(aux);
        }

        return dtoList;
    }

    @Override
    public ExperienceDTO saveExperience(ExperienceSaveDTO experience, Long user_id) {
        PersonEntity person = iPersonService.getPersonEntityById(user_id);

        ExperienceEntity experienceEntity = modelMapper.map(experience, ExperienceEntity.class);
        experienceEntity.setPerson(person);
        experienceRepository.save(experienceEntity);
        return modelMapper.map(experienceEntity, ExperienceDTO.class);
    }

    @Override
    public ExperienceDTO updateExperience(ExperienceDTO experience, Long id) {
        Optional<ExperienceEntity> updatedExperience = experienceRepository.findById(id);

        if(updatedExperience.isEmpty()) {
            throw new PortfolioException("Experience not found", HttpStatus.NOT_FOUND);
        }

        ExperienceEntity aux = updatedExperience.get();
        aux.setCompany(experience.getCompany());
        aux.setDescription(experience.getDescription());
        aux.setFinishDate(experience.getFinishDate());
        aux.setImage(experience.getImage());
        aux.setPosition(experience.getPosition());
        aux.setHidden(experience.isHidden());
        aux.setStartDate(experience.getStartDate());

        experienceRepository.save(aux);

        return modelMapper.map(aux, ExperienceDTO.class);
    }

    @Override
    public void deleteExperience(Long id) {
        Optional<ExperienceEntity> deletedExperience = experienceRepository.findById(id);

        if(deletedExperience.isEmpty()) {
            throw new PortfolioException("Experience not found", HttpStatus.NOT_FOUND);
        }

        ExperienceEntity aux = deletedExperience.get();
        experienceRepository.delete(aux);
    }
}
