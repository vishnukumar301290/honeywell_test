package com.iot.controllers;

import com.iot.common.DeviceFilter;
import com.iot.common.FilterCache;
import com.iot.common.FilterRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/filter")
public class DeviceFilterController {

    @Autowired
    private FilterCache filterCache;

    @PostMapping (path = "{deviceId}")
    public ResponseEntity<String> save(@PathVariable Integer deviceId, @RequestBody FilterRQ filterRQ) {
        DeviceFilter deviceFilter =DeviceFilter.valueOf(filterRQ.getFilter());
        filterCache.add(deviceId, deviceFilter, filterRQ.getFilterValue());
        return ResponseEntity.ok("ok");
    }


}
