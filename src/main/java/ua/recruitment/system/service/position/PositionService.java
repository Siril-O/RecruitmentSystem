package ua.recruitment.system.service.position;

import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.position.PositionStatus;

import java.util.List;

/**
 * Created by KIRIL on 08.11.2016.
 */
public interface PositionService {

    List<Position> findPositionInStatuses(List<PositionStatus> statuses);

    Position findPositionByCode(String code);

    void create(final Position entity);


}
