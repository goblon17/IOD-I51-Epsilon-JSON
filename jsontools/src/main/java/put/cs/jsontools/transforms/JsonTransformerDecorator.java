package put.cs.jsontools.transforms;

import lombok.Data;

/**
 * @Author adam ma kota
 */
@Data
public abstract class JsonTransformerDecorator implements JsonTransformer{
    private final JsonTransformer jsonTransformer;

    @Override
    public String transform(String json, String keys) {
        return jsonTransformer.transform(json, keys);
    }
}
