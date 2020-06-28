package by.karpov.ITSPartnertask.service;

import by.karpov.ITSPartnertask.database.entity.Lamp;
import by.karpov.ITSPartnertask.database.repository.LampRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LampServiceImpl implements LampService<Lamp> {

    private final LampRepo lampRepo;

    @Autowired
    public LampServiceImpl(LampRepo lampRepo) {
        this.lampRepo = lampRepo;
    }

    @Override
    public Lamp updateLampCondition(Lamp lamp, String condition) {
        lamp.setLampCondition(condition);
        return lampRepo.save(lamp);
    }
}
