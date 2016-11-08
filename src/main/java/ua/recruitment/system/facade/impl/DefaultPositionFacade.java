package ua.recruitment.system.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.recruitment.system.domain.Company;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.position.PositionStatus;
import ua.recruitment.system.facade.PositionFacade;
import ua.recruitment.system.service.company.CompanyService;
import ua.recruitment.system.service.position.PositionService;
import ua.recruitment.system.web.controller.position.dto.CreatePositionRequest;

import java.util.Date;
import java.util.UUID;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Component
public class DefaultPositionFacade implements PositionFacade {

    @Autowired
    private PositionService positionService;
    @Autowired
    private CompanyService companyService;

    @Override
    public void createPosition(CreatePositionRequest request) {
        Company company = companyService.findByName(request.getCompanyName());
        Position position = new Position();
        position.setCompany(company);
        position.setName(request.getName());
        position.setDescription(request.getDescription());
        position.setPositionStatus(PositionStatus.ACTIVE);
        position.setDateOfCreation(new Date());
        position.setCode(UUID.randomUUID().toString());
        positionService.create(position);
    }
}
