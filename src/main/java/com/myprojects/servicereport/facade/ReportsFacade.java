package com.myprojects.servicereport.facade;

import com.myprojects.servicereport.domain.Reports;
import com.myprojects.servicereport.dtos.ReportsDto;
import com.myprojects.servicereport.exception.ReportAlreadyExistsException;
import com.myprojects.servicereport.exception.ReportNotFoundException;
import com.myprojects.servicereport.mapper.ReportsMapper;
import com.myprojects.servicereport.service.ReportsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ReportsFacade {

    private final ReportsMapper reportsMapper;
    private final ReportsService reportsService;

    public List<ReportsDto> getAllReports() {
        return reportsMapper.mapToReportsDtoList(reportsService.getAllReports());
    }

    public ReportsDto getReportById(final Long id) throws ReportNotFoundException {
        return reportsMapper.mapToReportsDto(reportsService.getReportById(id));
    }

    public List<ReportsDto> getReportByDateMonth(short dateMonth) {
        return reportsMapper.mapToReportsDtoList(reportsService.getReportsByDateMonth(dateMonth));
    }

    public List<ReportsDto> getReportByDateYear(short dateYear) {
        return reportsMapper.mapToReportsDtoList(reportsService.getReportsByDateYear(dateYear));
    }

    public ReportsDto saveReport(ReportsDto reportDto) throws ReportNotFoundException, ReportAlreadyExistsException {
        Reports newReport = reportsMapper.mapToReports(reportDto);
        reportsService.saveReport(newReport);
        return reportsMapper.mapToReportsDto(newReport);
    }

    public ReportsDto updateReport(Long reportId, ReportsDto reportDto) throws ReportNotFoundException {
        Reports updatedReport = reportsMapper.mapToReports(reportDto);
        updatedReport.setReportId(reportId);
        reportsService.updateReport(updatedReport);
        return reportsMapper.mapToReportsDto(updatedReport);
    }

    public void deleteReport(Long reportId) throws ReportNotFoundException {
        reportsService.deleteReport(reportId);
    }

}
