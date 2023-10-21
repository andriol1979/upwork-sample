package com.kbtool.configuration;

import com.kbtool.dto.UserDto;
import com.kbtool.entity.User;
import org.bson.types.ObjectId;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    @Scope("singleton")
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STANDARD)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        Converter<String, ObjectId> toObjectId = new AbstractConverter<>() {
            protected ObjectId convert(String source) {
                return source == null ? null : new ObjectId(source);
            }
        };
        // Mapping objects
        mapUserDto2User(modelMapper, toObjectId);

        return modelMapper;
    }

    private void mapUserDto2User(ModelMapper modelMapper, Converter<String, ObjectId> toObjectId) {
        TypeMap<UserDto, User> typeMapUserDto = modelMapper.createTypeMap(UserDto.class, User.class);
        typeMapUserDto.addMappings(mapper -> {
            mapper.using(toObjectId)
                .map(UserDto::getCompanyId, User::setCompanyId);
        });
    }
}
