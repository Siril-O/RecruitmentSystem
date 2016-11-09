package ua.recruitment.system.repository;

import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.repository.util.CrudRepository;

/**
 * Created by KIRIL on 08.11.2016.
 */
public interface PositionApplicationRepository extends CrudRepository<PositionApplication> {

    PositionApplication findPositionApplicationByCode(String code);

}
