package ar.edu.utn.frc.tup.lciii.confings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.modelmapper.Conditions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfing {

    @Bean
    public ModelMapper modelMaper(){
        ModelMapper modelMapper= new ModelMapper();
        return modelMapper;
    }
    @Bean("mergerMapper")
    public ModelMapper mergerMapper (){
        ModelMapper mapper= new ModelMapper();
        mapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull());
        return mapper;
    }

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper= new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }


}
