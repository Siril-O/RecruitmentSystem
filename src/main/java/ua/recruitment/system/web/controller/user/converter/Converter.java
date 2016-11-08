package ua.recruitment.system.web.controller.user.converter;

import java.util.List;

/**
 * Created by Kyrylo_Kovalchuk on 11/7/2016.
 */
public interface Converter<I,O> {
    O convert(I input);
    O convert(I input, O output);
    List<O> convert(List<I> input);
}
