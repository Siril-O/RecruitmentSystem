package ua.recruitment.system.facade;

import ua.recruitment.system.domain.PositionApplicationStatus;
import ua.recruitment.system.web.controller.position.dto.PositionApplicationDto;

import java.util.List;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
public interface PositionApplicationFacade {

    List<PositionApplicationDto> getPositionApplications(List<String> positionCodes, List<String> applicantEmails,
                                                         List<PositionApplicationStatus> statuses);


}
