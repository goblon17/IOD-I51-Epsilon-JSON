package put.cs.jsontools.transformations;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseHelper {
    public JsonParseHelper() {
    }

    public static boolean isValid(String json){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.readTree(json);
        }
        catch (JacksonException e){
            return false;
        }
        return true;
    }
}
