package put.cs.jsontools.transformations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class BeautifierTransformationImpl implements BeautifierTransformation{
    @Override
    public String transformFromUglyToBeauty(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            return jsonNode.toPrettyString();
        }
        catch (JsonProcessingException e){
            return null;
        }
    }
}
