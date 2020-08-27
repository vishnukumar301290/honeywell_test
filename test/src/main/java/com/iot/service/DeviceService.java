package com.iot.service;

import com.iot.common.DeviceFilter;
import com.iot.model.DeviceRQ;
import com.iot.model.DeviceRS;

import java.util.List;

public interface DeviceService {

    Integer save(DeviceRQ deviceRQ);
    List<DeviceRS> get(int deviceId, Integer filterValue, DeviceFilter deviceFilter);

}
