package ru.push.backend;

import java.util.List;

public interface DeviceDAO {
    final int COUNT_ITEM_PAGE = 100;
    List<RegisteredDevice> getAll();
    void addItem(RegisteredDevice item);
    void updateItem(RegisteredDevice pushId);
    RegisteredDevice getDeviceByPushId(String id);

    List<RegisteredDevice> getPage(int page);

    void delete(String pushId);
}
