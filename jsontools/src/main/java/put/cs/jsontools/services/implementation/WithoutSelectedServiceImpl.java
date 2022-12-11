package put.cs.jsontools.services.implementation;

import org.springframework.stereotype.Service;
import put.cs.jsontools.exceptions.InvalidJsonFormatException;
import put.cs.jsontools.services.WithoutSelectedService;
import put.cs.jsontools.transformations.WithoutSelectedTransformation;

@Service
public class WithoutSelectedServiceImpl implements WithoutSelectedService {

    private final WithoutSelectedTransformation transformation;

    public WithoutSelectedServiceImpl(WithoutSelectedTransformation transformation) {this.transformation = transformation;}
    @Override
    public String getOnlySelectedJson(String json, String keys) throws InvalidJsonFormatException {
        String result = transformation.transformToWithoutSelected(json, keys);
        if (result == null) {
            throw new InvalidJsonFormatException();
        }
        return result;
    }
}
