package ua.recruitment.system.service.position;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.position.PositionStatus;
import ua.recruitment.system.repository.PositionRepository;

import java.util.List;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Service
public class DefaultPositionService implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findPositionInStatuses(List<PositionStatus> statuses) {
        Validate.notEmpty(statuses, "Statuses for position can not be empty");
        return positionRepository.findPositionInStatuses(statuses);
    }

    @Override
    public Position findPositionByCode(String code) {
        return positionRepository.findPositionByCode(code);
    }

    @Override
    public void create(Position entity) {
        positionRepository.create(entity);
    }
}
