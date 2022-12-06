package put.cs.jsontools.services.implementation;


import org.springframework.stereotype.Service;
import put.cs.jsontools.exceptions.InvalidJsonFormatException;
import put.cs.jsontools.services.BeautifierService;
import put.cs.jsontools.transformations.BeautifierTransformation;

@Service
public class BeautifierServiceImpl implements BeautifierService {

    private final BeautifierTransformation transformation;

    public BeautifierServiceImpl(BeautifierTransformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public String getBeautifiedJson(String json) throws InvalidJsonFormatException {
        String result = transformation.transformFromUglyToBeauty(json);
        if(result==null){
            throw new InvalidJsonFormatException();
        }
        return result;
    }
}
