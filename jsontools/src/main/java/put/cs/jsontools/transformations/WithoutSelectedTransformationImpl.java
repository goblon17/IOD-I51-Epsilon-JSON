package put.cs.jsontools.transformations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class WithoutSelectedTransformationImpl implements WithoutSelectedTransformation {
    @Override
    public String transformToWithoutSelected(String json, String keys) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            List<String> keysList = Arrays.asList(keys.split("\\s*,\\s*"));
            removeKeys(jsonNode, keysList);
            return objectMapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static void removeKeys(final JsonNode jsonNode, List<String> keysToRemove) {
        Iterator<Map.Entry<String, JsonNode>> iter = jsonNode.fields();

        while (iter.hasNext()) {
            Map.Entry<String, JsonNode> entry = iter.next();
            if (keysToRemove.contains(entry.getKey())) {
                iter.remove();
            } else if (entry.getValue().isContainerNode()) {
                removeKeys(entry.getValue(), keysToRemove);
            }
        }
    }
}
