package ua.recruitment.system.facade.impl;

import ua.recruitment.system.domain.Company;
import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.domain.PositionApplicationStatus;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.domain.position.PositionStatus;
import ua.recruitment.system.domain.user.Applicant;
import ua.recruitment.system.facade.PositionFacade;
import ua.recruitment.system.service.company.CompanyService;
import ua.recruitment.system.service.position.PositionService;
import ua.recruitment.system.service.position.application.PositionApplicationService;
import ua.recruitment.system.service.user.UserService;
import ua.recruitment.system.web.controller.position.dto.ApplyPositionRequest;
import ua.recruitment.system.web.controller.position.dto.CreatePositionRequest;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Component
public class DefaultPositionFacade implements PositionFacade {

    @Autowired
    private PositionService positionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    @Autowired
    private PositionApplicationService positionApplicationService;

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

    @Override
    public void applyApplicantOnPosition(final ApplyPositionRequest request) {
        Applicant applicant = userService.getUserByEmail(request.getApplicantEmail(), Applicant.class);
        Position position = positionService.findPositionByCode(request.getPositionCode());
        PositionApplication positionApplication = new PositionApplication();
        positionApplication.setApplicant(applicant);
        positionApplication.setPosition(position);
        positionApplication.setCurriculumVitae(request.getCurriculumVitae());
        positionApplication.setApplyDate(new Date());
        positionApplication.setStatus(PositionApplicationStatus.CANDIDATE_APPLIED);
        positionApplicationService.create(positionApplication);
    }
}
