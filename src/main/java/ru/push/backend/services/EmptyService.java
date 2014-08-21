package ru.push.backend.services;

import ru.push.backend.models.RegisteredDevice;

import java.util.ArrayList;
import java.util.List;

public class EmptyService implements ServicePattern {
    @Override
    public RegisteredDevice addDevice(RegisteredDevice bank) {
        return null;
    }

    @Override
    public void deleteDevice(String id) {

    }

    @Override
    public RegisteredDevice getDeviceByPushId(String name) {
        return null;
    }

    @Override
    public RegisteredDevice updateDevice(RegisteredDevice bank) {
        return null;
    }

    @Override
    public List<RegisteredDevice> getAll() {
        return new ArrayList<RegisteredDevice>(0);
    }
}
