package put.cs.jsontools.transforms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class BeautifierTransformerImpl implements JsonTransformer{
    @Override
    public String transform(String json, String keys) {
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
