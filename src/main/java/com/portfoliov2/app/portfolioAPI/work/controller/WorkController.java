package com.portfoliov2.app.portfolioAPI.work.controller;

import com.portfoliov2.app.portfolioAPI.work.dto.WorkDTO;
import com.portfoliov2.app.portfolioAPI.work.dto.WorkSaveDTO;
import com.portfoliov2.app.portfolioAPI.work.entity.WorkEntity;
import com.portfoliov2.app.portfolioAPI.work.service.IWorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showcase")
public class WorkController {

    private final IWorkService iWorkService;

    public WorkController(IWorkService iWorkService) {
        this.iWorkService = iWorkService;
    }

    @GetMapping
    public ResponseEntity<List<WorkDTO>> getWorks() {
        return ResponseEntity.status(HttpStatus.OK).body(iWorkService.getWorks());
    }

    @PostMapping(value = "/{userId}/create")
    public ResponseEntity<WorkDTO> saveWork(@RequestBody WorkSaveDTO work, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(iWorkService.saveWork(work, userId));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<WorkDTO> updateWork(@RequestBody WorkDTO work, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iWorkService.updateWork(work, id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteWork(@PathVariable Long id) {
        iWorkService.deleteWork(id);
        return ResponseEntity.status(HttpStatus.OK).body("Work deleted.");
    }

}
