package com.myprojects.servicereport.repository;

import com.myprojects.servicereport.domain.Reports;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReportsRepository extends CrudRepository<Reports, Long> {

    @Override
    @NotNull
    List<Reports> findAll();

    @Override
    @NotNull
    Optional<Reports> findById(@NotNull Long reportsId);

    @NotNull
    List<Reports> findByDate_Month(short date_month);

    @NotNull
    List<Reports> findByDate_Year(int date_year);

    @Override
    @NotNull
    Reports save(@NotNull Reports report);

    @Override
    void deleteById(@NotNull Long reportId);
}
