package ua.recruitment.system.service.position.application.impl;

import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.repository.PositionApplicationRepository;
import ua.recruitment.system.service.position.application.PositionApplicationService;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
@Service
public class DefaultPositionApplicationService implements PositionApplicationService {

    @Autowired
    private PositionApplicationRepository positionApplicationRepository;

    @Override
    public void create(final PositionApplication positionApplication) {
        Validate.notNull(positionApplication);
        positionApplicationRepository.create(positionApplication);
    }
}
