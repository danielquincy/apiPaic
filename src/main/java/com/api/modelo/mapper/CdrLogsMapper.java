package com.api.modelo.mapper;

import com.api.modelo.CdrLogs;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CdrLogsMapper implements RowMapper<CdrLogs> {

    @Override
    public CdrLogs mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
