package com.iot.service;

import com.iot.DeviceRepository;
import com.iot.common.DeviceFilter;
import com.iot.entity.DeviceData;
import com.iot.model.DeviceRQ;
import com.iot.model.DeviceRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Integer save(DeviceRQ deviceRQ) {
        DeviceData deviceData = new DeviceData();
        deviceData.setData(deviceRQ.getData());
        deviceData.setDeviceId(deviceRQ.getDeviceId());
        deviceRepository.save(deviceData);
        return deviceData.getId();
    }


    @Override
    public List<DeviceRS> get(int deviceId, Integer filterValue, DeviceFilter deviceFilter) {
        List<DeviceData> deviceDataList = null;
        if (deviceFilter != null  && filterValue != null) {
            if (deviceFilter.equals(DeviceFilter.gt)) {
                deviceDataList =  deviceRepository.findByDeviceIdAndDataGreaterThan(deviceId, filterValue);
            } else if (deviceFilter.equals(DeviceFilter.lt)) {
                deviceDataList = deviceRepository.findByDeviceIdAndDataLessThan(deviceId, filterValue);
            }
        } else {
            deviceDataList = deviceRepository.findByDeviceId(deviceId);
        }
        List<DeviceRS> deviceRSList = null;
        if (deviceDataList != null) {
            deviceRSList = deviceDataList.stream().map(deviceData -> {
                DeviceRS deviceRS = new DeviceRS();
                deviceRS.setData(deviceData.getData());
                deviceRS.setDeviceId(deviceData.getDeviceId());
                return deviceRS;
            }).collect(Collectors.toList());
        }
        return deviceRSList;
    }
}
