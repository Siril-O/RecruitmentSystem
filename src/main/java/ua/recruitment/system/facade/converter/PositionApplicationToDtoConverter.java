package ua.recruitment.system.facade.converter;

import ua.recruitment.system.domain.PositionApplication;
import ua.recruitment.system.web.controller.position.dto.PositionApplicationDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kyrylo_Kovalchuk on 11/9/2016.
 */
@Component
public class PositionApplicationToDtoConverter implements Converter<PositionApplication, PositionApplicationDto> {

    @Autowired
    private PositionToDtoConverter positionToDtoConverter;
    @Autowired
    private UserToDtoConverter userToDtoConverter;

    @Override
    public PositionApplicationDto convert(final PositionApplication input) {
        return convert(input, new PositionApplicationDto());
    }

    @Override
    public PositionApplicationDto convert(final PositionApplication input, final PositionApplicationDto output) {
        output.setCode(input.getCode());
        output.setCurriculumVitae(input.getCurriculumVitae());
        output.setStatus(input.getStatus());
        output.setApplyDate(input.getApplyDate());
        output.setLastStatusChangeDate(input.getLastStatusChangeDate());

        output.setApplicant(userToDtoConverter.convert(input.getApplicant()));
        output.setPosition(positionToDtoConverter.convert(input.getPosition()));
        return output;
    }

    @Override
    public List<PositionApplicationDto> convert(final List<PositionApplication> input) {
        return input.stream().map(this::convert).collect(Collectors.toList());
    }
}
