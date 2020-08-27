package com.iot;

import com.iot.entity.DeviceData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<DeviceData, Integer> {

    List<DeviceData> findByDeviceIdAndDataGreaterThan(int deviceId, int data);
    List<DeviceData> findByDeviceIdAndDataGreaterThanEqual(int deviceId, int data);
    List<DeviceData> findByDeviceIdAndDataLessThan(int deviceId, int data);
    List<DeviceData> findByDeviceIdAndDataLessThanEqual(int deviceId, int data);
    List<DeviceData> findByDeviceId(int deviceId);
}
