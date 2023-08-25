package com.api.logica.serviceImpl;

import com.api.logica.service.CallDetailRecordsService;
import com.api.modelo.CallDetailRecords;
import com.api.modelo.CallDetailRecords;
import com.api.repo.CallDetailRecordsCrud;
import com.api.repo.dao.CallDetailRecordsDAO;
import com.api.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CallDetailRecordsServiceImpl implements CallDetailRecordsService {

    private final CallDetailRecordsDAO oCallDetailRecordsDAO;

    private final CallDetailRecordsCrud oCallDetailRecordsCrud;

    @Autowired
    public CallDetailRecordsServiceImpl(final CallDetailRecordsDAO oCallDetailRecordsDAO,
                                        final CallDetailRecordsCrud oCallDetailRecordsCrud) {
        this.oCallDetailRecordsDAO = oCallDetailRecordsDAO;
        this.oCallDetailRecordsCrud = oCallDetailRecordsCrud;
    }

    public List<CallDetailRecords> findAll() {
        return (List<CallDetailRecords>) oCallDetailRecordsCrud.findAll();
    }

    public List<CallDetailRecords> findByDate(String oDesde, String oHasta) throws Exception {
        Timestamp desde = Utils.toTimestamp(oDesde);
        Timestamp hasta = Utils.toTimestamp(oHasta);

        List<CallDetailRecords> oLista = (List<CallDetailRecords>) oCallDetailRecordsCrud.findAll();
        return oLista
                .stream()
                .filter(x -> x.getRecordDate().after(desde)
                        && x.getRecordDate().before(hasta))
                .collect(Collectors.toList());
    }

    public List<CallDetailRecords> findByImsi(String oDesde, String oHasta, String oImsi) throws Exception {
        Timestamp desde = Utils.toTimestamp(oDesde);
        Timestamp hasta = Utils.toTimestamp(oHasta);

        List<CallDetailRecords> oLista = (List<CallDetailRecords>) oCallDetailRecordsCrud.findAll();
        return oLista
                .stream()
                .filter(x -> x.getRecordDate().after(desde)
                        && x.getRecordDate().before(hasta)
                        && x.getImsi().equals(oImsi)
                )
                .collect(Collectors.toList());
    }

    public List<CallDetailRecords> findByMsisdn(String oDesde, String oHasta, String oMsisdn) throws Exception {
        Timestamp desde = Utils.toTimestamp(oDesde);
        Timestamp hasta = Utils.toTimestamp(oHasta);

        List<CallDetailRecords> oLista = (List<CallDetailRecords>) oCallDetailRecordsCrud.findAll();
        return oLista
                .stream()
                .filter(x -> x.getRecordDate().after(desde)
                        && x.getRecordDate().before(hasta)
                        && x.getMsisdn().equals(oMsisdn))
                .collect(Collectors.toList());
    }
    public List<CallDetailRecords> findByAll(String oDesde, String oHasta, String oImsi , String oMsisdn) throws Exception {
        Timestamp desde = Utils.toTimestamp(oDesde);
        Timestamp hasta = Utils.toTimestamp(oHasta);

        List<CallDetailRecords> oLista = (List<CallDetailRecords>) oCallDetailRecordsCrud.findAll();
        return oLista
                .stream()
                .filter(x -> x.getRecordDate().after(desde)
                        && x.getRecordDate().before(hasta)
                        && x.getImsi().equals(oImsi)
                        && x.getMsisdn().equals(oMsisdn))
                .collect(Collectors.toList());
    }

}





