package ua.recruitment.system.repository;

import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.position.PositionStatus;
import ua.recruitment.system.repository.util.CrudRepository;

import java.util.List;

/**
 * Created by KIRIL on 08.11.2016.
 */
public interface PositionRepository extends CrudRepository<Position> {

    List<Position> findPositionInStatuses(List<PositionStatus> statuses);
    Position findPositionByCode(String code);
}
