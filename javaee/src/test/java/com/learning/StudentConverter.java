package com.learning;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

/**
 * @Auther: zuowenzhi 2023/3/2 created
 * @Description: com.learning
 * @version: 1.0
 */

@Mapper
public interface StudentConverter {

    StudentConverter INSTANCE = Mappers.getMapper(StudentConverter.class);
    @Mappings({
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "birthday",target = "birthday",dateFormat = "yyyy-MM-dd")
    })
    StudentDto converter(Student student, String address, LocalDateTime birthday);
//    @Mappings({
//            @Mapping(target = "cardLevel",expression = "java(CardLevel.valuesOf(studentDto.cardLevel))")
//    })
//    Student converterDto2Entity(StudentDto studentDto);
}

