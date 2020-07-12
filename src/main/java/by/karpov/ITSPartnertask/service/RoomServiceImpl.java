package by.karpov.ITSPartnertask.service;

import by.karpov.ITSPartnertask.database.entity.Room;
import by.karpov.ITSPartnertask.database.repository.RoomRepo;
import by.karpov.ITSPartnertask.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Slf4j
@Service
@Transactional
public class RoomServiceImpl implements RoomService<Room> {

    private final RoomRepo roomRepo;

    @Autowired
    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public Room save(Room room) {
        //log.info("In RoomServiceImpl save{}", room);
        return roomRepo.save(room);
    }

    @Override
    public List<Room> getAll() {
        //log.info("In RoomServiceImpl getAll");
        return roomRepo.findAll();
    }

    @Override
    public Room findById(Long id) throws ValidationException {
        Room room = roomRepo.findRoomById(id);
        if (room == null) {
            throw new ValidationException("Room not found!");
        }
        return room;
    }

    @Override
    public void delete(Room room) {
        roomRepo.delete(room);
    }
}
