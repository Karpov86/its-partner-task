package by.karpov.ITSPartnertask.database.repository;

import by.karpov.ITSPartnertask.database.entity.Lamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LampRepo extends JpaRepository<Lamp, Long> {
}
