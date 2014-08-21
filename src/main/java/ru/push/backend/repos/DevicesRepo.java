package ru.push.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.push.backend.models.RegisteredDevice;

@Repository
public interface DevicesRepo extends JpaRepository<RegisteredDevice, String> {

}
