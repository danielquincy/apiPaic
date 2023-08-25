package com.api.logica.service;


import com.api.modelo.CallDetailRecords;

import java.util.List;

public interface CallDetailRecordsService {

    List<CallDetailRecords> findAll();
    List<CallDetailRecords> findByDate(String oDesde, String oHasta) throws Exception;

    List<CallDetailRecords> findByImsi(String oDesde, String oHasta, String oImsi) throws Exception;

    List<CallDetailRecords> findByMsisdn(String oDesde, String oHasta, String oMsisdn) throws Exception;

    List<CallDetailRecords> findByAll(String oDesde, String oHasta, String oImsi , String oMsisdn) throws Exception;

}


