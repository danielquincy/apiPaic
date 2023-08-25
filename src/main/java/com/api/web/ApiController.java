package com.api.web;

import com.api.logica.service.CallDetailRecordsService;
import com.api.modelo.CallDetailRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController{
    private final CallDetailRecordsService oCallDetailRecordsService;

    @Autowired
    public ApiController(CallDetailRecordsService oCallDetailRecordsService) {
        this.oCallDetailRecordsService = oCallDetailRecordsService;
    }

    @GetMapping(value="/find",  produces= MediaType.APPLICATION_JSON_VALUE)
    public List<CallDetailRecords> findByDate(){
        return  oCallDetailRecordsService.findAll();
    }
    @GetMapping(value="/find/{fechaDesde}/{fechaHasta}" ,  produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CallDetailRecords> findByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaDesde,
                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaHasta) throws Exception {
        return  oCallDetailRecordsService.findByDate(fechaDesde,fechaHasta );

    }

    @GetMapping(value="/find/{fechaDesde}/{fechaHasta}/{imsi}" , produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CallDetailRecords> findByImsi(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaDesde,
                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaHasta,
                                               @PathVariable String imsi) throws Exception {
      return  oCallDetailRecordsService.findByImsi(fechaDesde,fechaHasta,imsi);

    }



    @GetMapping(value="/find/{fechaDesde}/{fechaHasta}/{msisdn}" ,   produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CallDetailRecords> findByMsisdn(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaDesde,
                                          @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaHasta,
                                          @PathVariable String msisdn) throws Exception {
      return  oCallDetailRecordsService.findByMsisdn(fechaDesde,fechaHasta,msisdn);

    }

    @GetMapping(value="/find/{fechaDesde}/{fechaHasta}/{imsi}/{msisdn}" , produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CallDetailRecords> findByAll(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaDesde,
                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fechaHasta,
                                          @PathVariable String imsi,
                                          @PathVariable String msisdn) throws Exception {
      return  oCallDetailRecordsService.findByAll(fechaDesde,fechaHasta ,imsi ,msisdn);

    }

}
