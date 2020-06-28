package by.karpov.ITSPartnertask.database.repository;

import by.karpov.ITSPartnertask.database.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Long> {

    List<Room> findAll();

    Room findRoomById(Long id);

    @Override
    void delete(Room room);
}
