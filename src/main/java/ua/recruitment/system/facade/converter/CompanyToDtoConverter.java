package ua.recruitment.system.facade.converter;

import org.springframework.stereotype.Component;
import ua.recruitment.system.domain.Company;
import ua.recruitment.system.web.controller.company.dto.CompanyDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@Component
public class CompanyToDtoConverter implements Converter<Company, CompanyDto> {
    @Override
    public CompanyDto convert(final Company input) {
        return convert(input, new CompanyDto());
    }

    @Override
    public CompanyDto convert(final Company input, final CompanyDto output) {
        if (input == null) {
            return output;
        }
        output.setName(input.getName());
        output.setDescription(input.getDescription());
        return output;
    }

    @Override
    public List<CompanyDto> convert(final List<Company> input) {
        return input.stream().map(this::convert).collect(Collectors.toList());
    }
}
