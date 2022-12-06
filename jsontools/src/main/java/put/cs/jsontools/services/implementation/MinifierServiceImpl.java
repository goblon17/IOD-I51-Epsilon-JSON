package put.cs.jsontools.services.implementation;

import org.springframework.stereotype.Service;
import put.cs.jsontools.exceptions.FieldInJsonNotFoundException;
import put.cs.jsontools.exceptions.InvalidJsonFormatException;
import put.cs.jsontools.services.MinifierService;
import put.cs.jsontools.transformations.MinifierTransformation;

@Service
public class MinifierServiceImpl implements MinifierService {

    private final MinifierTransformation transformation;

    public MinifierServiceImpl(MinifierTransformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String getMinificatedJson(String json) throws InvalidJsonFormatException{
        String result = transformation.transformFromBeautyToUgly(json);
        if(result==null){
            throw new InvalidJsonFormatException();
        }
        return result;
    }
}
