package com.portfoliov2.app.portfolioAPI.education.service;

import com.portfoliov2.app.portfolioAPI.education.dto.EducationDTO;
import com.portfoliov2.app.portfolioAPI.education.dto.EducationSaveDTO;
import com.portfoliov2.app.portfolioAPI.education.entity.EducationEntity;
import com.portfoliov2.app.portfolioAPI.education.repository.EducationRepository;
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
public class ImpEducationService implements IEducationService {

    private final EducationRepository educationRepository;

    private final IPersonService iPersonService;

    private final ModelMapper modelMapper;

    public ImpEducationService(EducationRepository educationRepository, IPersonService iPersonService, ModelMapper modelMapper) {
        this.educationRepository = educationRepository;
        this.iPersonService = iPersonService;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<EducationDTO> getEducations() {
        List<EducationEntity> educationEntityList = educationRepository.findAll();
        List<EducationDTO> educationDTOs = new ArrayList<>();

        for(EducationEntity item : educationEntityList) {
            EducationDTO aux = modelMapper.map(item, EducationDTO.class);
            educationDTOs.add(aux);
        }

        return educationDTOs;
    }

    @Override
    public EducationDTO saveEducation(EducationSaveDTO education, Long userId) {
        PersonEntity person = iPersonService.getPersonEntityById(userId);

        EducationEntity educationEntity = modelMapper.map(education, EducationEntity.class);
        educationEntity.setPerson(person);
        educationRepository.save(educationEntity);

        return modelMapper.map(educationEntity, EducationDTO.class);
    }


    @Override
    public EducationDTO updateEducation(EducationDTO education, Long id) {
        Optional<EducationEntity> updatedEducation = educationRepository.findById(id);

        if(updatedEducation.isEmpty()) {
            throw new PortfolioException("Education not found", HttpStatus.NOT_FOUND);
        }

        EducationEntity aux = updatedEducation.get();
        aux.setTitle(education.getTitle());
        aux.setDescription(education.getDescription());
        aux.setInstitution(education.getInstitution());
        aux.setStartDate(education.getStartDate());
        aux.setFinishDate(education.getFinishDate());
        aux.setImage(education.getImage());
        aux.setHidden(education.isHidden());

        educationRepository.save(aux);
        return modelMapper.map(aux, EducationDTO.class);
    }

    @Override
    public void deleteEducation(Long id) {
        Optional<EducationEntity> deletedEducation = educationRepository.findById(id);
        if(deletedEducation.isEmpty()) {
            throw new PortfolioException("Education not found", HttpStatus.NOT_FOUND);
        }

        EducationEntity aux = deletedEducation.get();
        educationRepository.delete(aux);
    }

}
