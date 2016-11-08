package ua.recruitment.system.web.controller.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.position.PositionStatus;
import ua.recruitment.system.facade.PositionFacade;
import ua.recruitment.system.service.position.PositionService;
import ua.recruitment.system.web.controller.position.converter.PositionToDtoConverter;
import ua.recruitment.system.web.controller.position.dto.CreatePositionRequest;
import ua.recruitment.system.web.controller.position.dto.PositionDto;

import java.util.List;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Controller
@RequestMapping("position")
@Secured("isAuthenticated()")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private PositionFacade positionFacade;

    @Autowired
    private PositionToDtoConverter positionToDtoConverter;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PositionDto> getPositions(@RequestBody List<PositionStatus> statuses) {
        List<Position> positions = positionService.findPositionInStatuses(statuses);
        return positionToDtoConverter.convert(positions);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createPosition(@RequestBody CreatePositionRequest request) {
        positionFacade.createPosition(request);
    }
}
