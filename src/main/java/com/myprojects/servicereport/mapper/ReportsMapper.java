package com.myprojects.servicereport.mapper;

import com.myprojects.servicereport.domain.Reports;
import com.myprojects.servicereport.dtos.ReportsDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportsMapper {
    public Reports mapToReports(final ReportsDto reportsDto) {
        return Reports.builder()
                .reportId(reportsDto.getReportId())
                .date(reportsDto.getDate())
                .ministryTime(reportsDto.getMinistryTime())
                .ldcTime(reportsDto.getReportId())
                .studies(reportsDto.getStudies())
                .build();
    }

    public ReportsDto mapToReportsDto(final Reports reports) {
        return ReportsDto.builder()
                .reportId(reports.getReportId())
                .date(reports.getDate())
                .ministryTime(reports.getMinistryTime())
                .ldcTime(reports.getLdcTime())
                .studies(reports.getStudies())
                .build();
    }

    public List<ReportsDto> mapToReportsDtoList(final @NotNull List<Reports> reportsList) {
        return reportsList.stream()
                .map(this::mapToReportsDto)
                .collect(Collectors.toList());
    }
}
