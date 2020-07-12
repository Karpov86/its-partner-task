package by.karpov.ITSPartnertask.service;

import by.karpov.ITSPartnertask.aspect.AspectAnnotation;
import by.karpov.ITSPartnertask.database.entity.Lamp;
import by.karpov.ITSPartnertask.database.repository.LampRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Slf4j
@Service
@Transactional
public class LampServiceImpl implements LampService<Lamp> {

    private final LampRepo lampRepo;

    @Autowired
    public LampServiceImpl(LampRepo lampRepo) {
        this.lampRepo = lampRepo;
    }

    @Override
    @AspectAnnotation
    public Lamp updateLampCondition(Lamp lamp, String condition) {
        //log.info("In RoomServiceImpl update{}{}", lamp, condition);
        lamp.setLampCondition(condition);
        return lampRepo.save(lamp);
    }
}
