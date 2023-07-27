package com.portfoliov2.app.portfolioAPI.work.service;

import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioException;
import com.portfoliov2.app.portfolioAPI.person.service.IPersonService;
import com.portfoliov2.app.portfolioAPI.work.dto.WorkDTO;
import com.portfoliov2.app.portfolioAPI.work.dto.WorkSaveDTO;
import com.portfoliov2.app.portfolioAPI.work.entity.WorkEntity;
import com.portfoliov2.app.portfolioAPI.work.repository.WorkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImpWorkService implements IWorkService {

    private final WorkRepository workRepository;

    private final IPersonService iPersonService;

    private final ModelMapper modelMapper;

    public ImpWorkService(WorkRepository workRepository, IPersonService iPersonService, ModelMapper modelMapper) {
        this.workRepository = workRepository;
        this.iPersonService = iPersonService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<WorkDTO> getWorks() {
        List<WorkEntity> workEntityList = workRepository.findAll();
        List<WorkDTO> workDTOList = new ArrayList<>();

        for(WorkEntity item : workEntityList) {
            WorkDTO aux = modelMapper.map(item, WorkDTO.class);
            workDTOList.add(aux);
        }

        return workDTOList;
    }

    @Override
    public WorkDTO saveWork(WorkSaveDTO work, Long userId) {
        PersonEntity person = iPersonService.getPersonEntityById(userId);

        WorkEntity workEntity = modelMapper.map(work, WorkEntity.class);
        workEntity.setPerson(person);

        workRepository.save(workEntity);

        return modelMapper.map(workEntity, WorkDTO.class);
    }

    @Override
    public void deleteWork(Long id) {
        WorkEntity deletedProject = workRepository.findById(id).orElse(null);

        if(deletedProject == null) {
            throw new PortfolioException("Project not found", HttpStatus.NOT_FOUND);
        }

        workRepository.delete(deletedProject);
    }

    @Override
    public WorkDTO updateWork(WorkDTO work, Long id) {
        Optional<WorkEntity> updatedWork = workRepository.findById(id);

        if(updatedWork.isEmpty()) {
            throw new PortfolioException("Project not found", HttpStatus.NOT_FOUND);
        }

        WorkEntity aux = updatedWork.get();
        aux.setDescription(work.getDescription());
        aux.setCategory(work.getCategory());
        aux.setImage(work.getImage());
        aux.setTitle(work.getTitle());
        aux.setRepositoryLink(work.getRepositoryLink());
        aux.setLiveSourceLink(work.getLiveSourceLink());
        aux.setHidden(work.isHidden());
        workRepository.save(aux);

        return modelMapper.map(aux, WorkDTO.class);
    }
}
