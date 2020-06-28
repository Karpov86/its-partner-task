package by.karpov.ITSPartnertask;

import by.karpov.ITSPartnertask.database.entity.Lamp;
import by.karpov.ITSPartnertask.database.entity.Room;
import by.karpov.ITSPartnertask.service.RoomServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Sql(scripts = "/populate_db_for_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class RoomServiceTest {

    @Autowired
    private RoomServiceImpl roomService;

    @Test
    @Transactional
    void findByIdTest() {
        Room room = roomService.findById(1L);
        Assert.assertNotNull(room);
        Assert.assertEquals("Belarus", room.getCountry());
    }

    @Test
    @Transactional
    void getAllTest() {
        List<Room> all = roomService.getAll();
        Assert.assertFalse(all.isEmpty());
        Assert.assertEquals(3, all.size());
    }

    @Test
    @Transactional
    void saveTest() {
        Room room = roomService.save(new Room("Test", "USA", new Lamp("off")));
        String result = room.getCountry() + ", " + room.getRoomName() + ", " + room.getLamp().getLampCondition();
        Assert.assertNotNull(room);
        Assert.assertEquals("USA, Test, off", result );
        roomService.delete(room);
    }

}
