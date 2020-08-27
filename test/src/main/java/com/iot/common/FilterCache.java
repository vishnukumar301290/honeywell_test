package com.iot.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FilterCache {

    private Map<Integer, DeviceFilterData> map = new HashMap<>();

    public void add(int deviceId, DeviceFilter filter, Integer filterValue) {
        DeviceFilterData deviceFilterData = new DeviceFilterData();
        deviceFilterData.setDeviceFilter(filter);
        deviceFilterData.setFilterValue(filterValue);
        map.put(deviceId, deviceFilterData);
    }

    public DeviceFilterData get(int deviceId) {
        return map.get(deviceId);
    }

}
