package put.cs.jsontools.services.implementation;

import org.springframework.stereotype.Service;
import put.cs.jsontools.exceptions.InvalidJsonFormatException;
import put.cs.jsontools.services.OnlySelectedService;
import put.cs.jsontools.transformations.OnlySelectedTransformation;

@Service
public class OnlySelectedServiceImpl implements OnlySelectedService {
    private final OnlySelectedTransformation transformation;

    public OnlySelectedServiceImpl(OnlySelectedTransformation transformation) {this.transformation = transformation;}

    @Override
    public String getOnlySelectedJson(String json, String keys) throws InvalidJsonFormatException {
        String result = transformation.transformToOnlySelected(json, keys);
        if (result == null) {
            throw new InvalidJsonFormatException();
        }
        return result;
    }
}
