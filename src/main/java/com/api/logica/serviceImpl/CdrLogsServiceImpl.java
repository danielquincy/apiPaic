package com.api.logica.serviceImpl;

import com.api.logica.service.CdrLogsService;
import com.api.modelo.CdrLogs;
import com.api.repo.CdrLogsCrud;
import com.api.repo.dao.CdrLogsDAO;
import com.api.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CdrLogsServiceImpl implements CdrLogsService {
    private final CdrLogsDAO oCdrLogsDAO;
    private final CdrLogsCrud oCdrLogsCrud;

    @Autowired
    public CdrLogsServiceImpl(CdrLogsDAO oCdrLogsDAO, CdrLogsCrud oCdrLogsCrud) {
        this.oCdrLogsDAO = oCdrLogsDAO;
        this.oCdrLogsCrud = oCdrLogsCrud;
    }

}
