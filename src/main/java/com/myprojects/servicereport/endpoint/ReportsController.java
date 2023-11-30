package com.myprojects.servicereport.endpoint;

import com.myprojects.servicereport.dtos.ReportsDto;
import com.myprojects.servicereport.exception.ReportAlreadyExistsException;
import com.myprojects.servicereport.exception.ReportNotFoundException;
import com.myprojects.servicereport.facade.ReportsFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("v1/sr")
public class ReportsController {

    private final ReportsFacade reportsFacade;

    @GetMapping("/reports")
    public List<ReportsDto> getAllReports() {
        return reportsFacade.getAllReports();
    }

    @GetMapping("/reports/{id}")
    public ReportsDto getReportById(@PathVariable("id") Long reportId) throws ReportNotFoundException {
        return reportsFacade.getReportById(reportId);
    }

    @GetMapping("/reports/{month}")
    public List<ReportsDto> getReportByDateMonth(@PathVariable("month") short dateMonth) {
        return reportsFacade.getReportByDateMonth(dateMonth);
    }

    @GetMapping("/reports/{year}")
    public List<ReportsDto> getReportByDateYear(@PathVariable("year") short dateYear) {
        return reportsFacade.getReportByDateYear(dateYear);
    }

    @PostMapping(value = "/reports", consumes = APPLICATION_JSON_VALUE)
    public ReportsDto createReport(@RequestBody ReportsDto reportDto) throws ReportNotFoundException,
            ReportAlreadyExistsException {
        return reportsFacade.saveReport(reportDto);
    }

    @PutMapping("/reports/{id}")
    public ReportsDto updateReport(@PathVariable("id") Long reportId, @RequestBody ReportsDto reportDto)
            throws ReportNotFoundException {
        return reportsFacade.updateReport(reportId, reportDto);
    }

    @DeleteMapping("/reports/{id}")
    public void deleteReport(@PathVariable("id") Long reportId) throws ReportNotFoundException {
        reportsFacade.deleteReport(reportId);
    }
}
