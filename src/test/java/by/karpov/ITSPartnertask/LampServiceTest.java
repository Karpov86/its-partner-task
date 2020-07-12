package by.karpov.ITSPartnertask;

import by.karpov.ITSPartnertask.database.entity.Lamp;
import by.karpov.ITSPartnertask.exception.ValidationException;
import by.karpov.ITSPartnertask.service.LampServiceImpl;
import by.karpov.ITSPartnertask.service.RoomServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Sql(scripts = "/populate_db_for_test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class LampServiceTest {

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private LampServiceImpl lampService;

    @Test
    @Transactional
    public void updateLampConditionTest() throws ValidationException {
        Lamp lamp = roomService.findById(1L).getLamp();
        String newCondition = "on";
        String exceptedCondition = "on";
        lampService.updateLampCondition(lamp, newCondition);

        Assert.assertNotNull(lamp);
        Assert.assertEquals(exceptedCondition, lamp.getLampCondition());

    }
}
