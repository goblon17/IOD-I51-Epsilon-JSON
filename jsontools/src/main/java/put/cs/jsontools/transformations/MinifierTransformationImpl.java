package put.cs.jsontools.transformations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MinifierTransformationImpl implements MinifierTransformation{
    @Override
    public String transformFromBeautyToUgly(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            return objectMapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
