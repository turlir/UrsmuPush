package ru.push.backend.services;

import ru.push.backend.models.RegisteredDevice;

import java.util.List;

public interface ServicePattern {
    RegisteredDevice addDevice(RegisteredDevice bank);
    void deleteDevice(String id);
    RegisteredDevice getDeviceByPushId(String name);
    RegisteredDevice updateDevice(RegisteredDevice new_item);
    List<RegisteredDevice> getAll();
}
