package ru.push.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.push.backend.models.RegisteredDevice;
import ru.push.backend.repos.DevicesRepo;

import java.util.List;

@Service
public class UrmsuAndroidPushService implements ServicePattern {

    @Autowired
    private DevicesRepo repo;

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
    public RegisteredDevice updateDevice(RegisteredDevice new_item) {
        return null;
    }

    @Override
    public List<RegisteredDevice> getAll() {
        return repo.findAll();
    }
}
