package ua.recruitment.system.facade.impl;

import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.facade.PositionApplicationFacade;
import ua.recruitment.system.facade.converter.PositionApplicationToDtoConverter;
import ua.recruitment.system.service.position.application.PositionApplicationService;
import ua.recruitment.system.web.controller.position.dto.GetPositionApplicationsRequest;
import ua.recruitment.system.web.controller.position.dto.PositionApplicationDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
@Component
public class DefaultPositionApplicationFacade implements PositionApplicationFacade {

    @Autowired
    private PositionApplicationService positionApplicationService;

    @Autowired
    private PositionApplicationToDtoConverter positionApplicationToDtoConverter;

    @Override
    public List<PositionApplicationDto> getPositionApplications(final GetPositionApplicationsRequest request) {
        List<PositionApplication> positionApplications = positionApplicationService.getFilteredPositionApplications(
                request.getPositionCodes(),
                request.getApplicantEmails(), request.getStatuses());
        return positionApplicationToDtoConverter.convert(positionApplications);
    }
}
