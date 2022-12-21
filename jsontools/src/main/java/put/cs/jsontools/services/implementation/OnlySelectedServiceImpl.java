package put.cs.jsontools.services.implementation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import put.cs.jsontools.exceptions.InvalidJsonFormatException;
import put.cs.jsontools.services.OnlySelectedService;
import put.cs.jsontools.transforms.JsonTransformer;

@Service
public class OnlySelectedServiceImpl implements OnlySelectedService {
    private final JsonTransformer jsonTransformer;

    public OnlySelectedServiceImpl(@Qualifier("onlySelectedTransformer") JsonTransformer jsonTransformer) {
        this.jsonTransformer = jsonTransformer;
    }

    @Override
    public String getOnlySelectedJson(String json, String keys) throws InvalidJsonFormatException {
        String result = jsonTransformer.transform(json, keys);
        if (result == null) {
            throw new InvalidJsonFormatException();
        }
        return result;
    }
}
