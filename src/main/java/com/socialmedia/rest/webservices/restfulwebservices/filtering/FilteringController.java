package com.socialmedia.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering", produces = "application/json")
    public MappingJacksonValue filtering() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue((new SomeBean("value1", "value2", "value3")));
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", SimpleBeanPropertyFilter
                .filterOutAllExcept("field1", "field3"));

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping(path = "/filtering-list", produces = "application/json")
    public MappingJacksonValue filteringList() {

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6")));

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", SimpleBeanPropertyFilter
                .filterOutAllExcept("field2", "field3"));

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
