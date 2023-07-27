package com.portfoliov2.app.portfolioAPI.work.service;

import com.portfoliov2.app.portfolioAPI.work.dto.WorkDTO;
import com.portfoliov2.app.portfolioAPI.work.dto.WorkSaveDTO;
import com.portfoliov2.app.portfolioAPI.work.entity.WorkEntity;

import java.util.List;

public interface IWorkService {
    // Get all works
    List<WorkDTO> getWorks();

    // save a new work
    WorkDTO saveWork(WorkSaveDTO work, Long userId);

    // update an existing work
    WorkDTO updateWork(WorkDTO work, Long id);

    // delete a work
    void deleteWork(Long id);
}
