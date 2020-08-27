package com.iot.controllers;

import com.iot.common.DeviceFilter;
import com.iot.common.DeviceFilterData;
import com.iot.common.FilterCache;
import com.iot.model.DeviceRQ;
import com.iot.model.DeviceRS;
import com.iot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/v1/device")
public class DeviceController {


    @Autowired
    private DeviceService deviceService;

    @Autowired
    private FilterCache filterCache;

    @GetMapping  (path = "/{id}")
    public ResponseEntity<List<Integer>> get(@PathVariable (value = "id") int id) {
        DeviceFilterData filterData = filterCache.get(id);
        List<DeviceRS> deviceRSList = null;
        if (filterData != null)
            deviceRSList = deviceService.get(id, filterData.getFilterValue(), filterData.getDeviceFilter());
        else
            deviceRSList = deviceService.get(id, null, null);
        return ResponseEntity.ok(deviceRSList.stream().map(DeviceRS::getData).collect(Collectors.toList()));
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<String> save(@PathVariable (value = "id") Integer id, @RequestBody DeviceRQ deviceRQ) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        deviceRQ.setDeviceId(id);
        Integer resourceId = deviceService.save(deviceRQ);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("ok");
    }

}