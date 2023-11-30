package com.myprojects.servicereport.service;

import com.myprojects.servicereport.domain.Reports;
import com.myprojects.servicereport.exception.ReportAlreadyExistsException;
import com.myprojects.servicereport.exception.ReportNotFoundException;
import com.myprojects.servicereport.repository.ReportsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class ReportsService {

    private final ReportsRepository reportsRepository;

    public List<Reports> getAllReports() {
        return reportsRepository.findAll().stream()
                .filter(r -> !r.isDeleted())
                .collect(Collectors.toList());
    }

    public Reports getReportById(final Long id) throws ReportNotFoundException {
        return reportsRepository.findById(id)
                .filter(r -> !r.isDeleted())
                .orElseThrow(ReportNotFoundException::new);
    }

    public List<Reports> getReportsByDateMonth(short dateMonth) {
        return reportsRepository.findByDate_Month(dateMonth).stream()
                .filter(r -> !r.isDeleted())
                .collect(Collectors.toList());
    }

    public List<Reports> getReportsByDateYear(short dateYear) {
        return reportsRepository.findByDate_Year(dateYear).stream()
                .filter(r -> !r.isDeleted())
                .collect(Collectors.toList());
    }

    public Reports saveReport(final @NotNull Reports report) throws ReportAlreadyExistsException {
        Long id = report.getReportId();
        if(id != null && reportsRepository.existsById(id)) {
            throw new ReportAlreadyExistsException();
        }
        return reportsRepository.save(report);
    }

    public Reports updateReport(final @NotNull Reports report) throws ReportNotFoundException {
        Long id = report.getReportId();
        if(id == null || !reportsRepository.existsById(id)) {
            throw new ReportNotFoundException();
        }
        return reportsRepository.save(report);
    }

    public void deleteReport(final Long id) {
        Reports report = reportsRepository.findById(id)
                .orElseThrow(ReportNotFoundException::new);
        report.setDeleted(true);
        reportsRepository.save(report);
    }
}
