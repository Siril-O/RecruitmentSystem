package ua.recruitment.system.service.position.application;

import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.domain.PositionApplicationStatus;

import java.util.List;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
public interface PositionApplicationService {

    void create(PositionApplication positionApplication);

    List<PositionApplication> getFilteredPositionApplications(List<String> positionCodes, List<String> emails,
                                                              List<PositionApplicationStatus> statuses);
}
