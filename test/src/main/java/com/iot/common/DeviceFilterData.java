package com.iot.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;


//@EqualsAndHashCode
//@Data
public class DeviceFilterData {
    private DeviceFilter deviceFilter;
    private int filterValue;

    public DeviceFilter getDeviceFilter() {
        return deviceFilter;
    }

    public void setDeviceFilter(DeviceFilter deviceFilter) {
        this.deviceFilter = deviceFilter;
    }

    public int getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(int filterValue) {
        this.filterValue = filterValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceFilterData that = (DeviceFilterData) o;
        return getFilterValue() == that.getFilterValue() &&
                getDeviceFilter() == that.getDeviceFilter();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeviceFilter(), getFilterValue());
    }
}
