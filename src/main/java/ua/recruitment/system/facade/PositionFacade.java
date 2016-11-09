package ua.recruitment.system.facade;

import ua.recruitment.system.web.controller.position.dto.ApplyPositionRequest;
import ua.recruitment.system.web.controller.position.dto.CreatePositionRequest;

/**
 * Created by KIRIL on 08.11.2016.
 */
public interface PositionFacade {
    void createPosition(CreatePositionRequest createPositionRequest);

    void applyForPosition(ApplyPositionRequest applyPositionRequest);
}
