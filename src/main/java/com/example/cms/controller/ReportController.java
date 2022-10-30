package com.example.cms.controller;
//import com.example.cms.controller.exceptions.ReportNotFoundException;
import com.example.cms.model.entity.Report;
import com.example.cms.model.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController

public class ReportController {
    @Autowired
    private final ReportRepository repository;

    public ReportController(ReportRepository repository) {
        this.repository = repository;
    }
   /* @GetMapping("/reports")
    List<Report> retrieveAllReports() {
        return repository.findAll();
    }*/

    @PostMapping("/reports")
    Report createReport(@RequestBody Report newReport) {
        return repository.save(newReport);
    }

    @GetMapping("/reports/{id}")
    Optional<Report> retrieveReport(@PathVariable("id") Long reportId) {
        return repository.findById(reportId);
        // .orElseThrow(() -> new AdminNotFoundException(adminId));
    }
    @DeleteMapping("/reports/{id}")
    void deleteReport(@PathVariable("id") Long reportId) {
        repository.deleteById(reportId);
    }

   /* @GetMapping("/reports/search/{searchstring}")
    List<Report> searchReport(@PathVariable("searchstring") String searchString) {
        return repository.search(searchString);
    } */
}