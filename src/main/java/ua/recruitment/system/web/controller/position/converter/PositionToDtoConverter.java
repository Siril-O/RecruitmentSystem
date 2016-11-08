package ua.recruitment.system.web.controller.position.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.recruitment.system.domain.position.Position;
import ua.recruitment.system.web.controller.company.converter.CompanyToDtoConverter;
import ua.recruitment.system.web.controller.company.dto.CompanyDto;
import ua.recruitment.system.web.controller.position.dto.PositionDto;
import ua.recruitment.system.web.controller.user.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by KIRIL on 08.11.2016.
 */
@Component
public class PositionToDtoConverter implements Converter<Position, PositionDto> {

    @Autowired
    private CompanyToDtoConverter companyToDtoConverter;

    @Override
    public PositionDto convert(Position input) {
        return new PositionDto();
    }

    @Override
    public PositionDto convert(Position input, PositionDto output) {
        if (input == null) {
            return output;
        }
        output.setDateOfCreation(input.getDateOfCreation());
        output.setName(input.getName());
        output.setDescription(input.getDescription());
        CompanyDto companyDto = companyToDtoConverter.convert(input.getCompany());
        output.setCompany(companyDto);
        output.setCode(input.getCode());
        return null;
    }

    @Override
    public List<PositionDto> convert(List<Position> input) {
        return input.stream().map(this::convert).collect(Collectors.toList());
    }
}
