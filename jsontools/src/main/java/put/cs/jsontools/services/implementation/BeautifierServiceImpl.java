package put.cs.jsontools.services.implementation;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import put.cs.jsontools.exceptions.InvalidJsonFormatException;
import put.cs.jsontools.services.BeautifierService;

import put.cs.jsontools.transforms.JsonTransformer;

@Service
public class BeautifierServiceImpl implements BeautifierService {

    private final JsonTransformer jsonTransformer;

    public BeautifierServiceImpl(@Qualifier("beautifierTransformerImpl") JsonTransformer jsonTransformer) {
        this.jsonTransformer = jsonTransformer;
    }

    @Override
    public String getBeautifiedJson(String json) throws InvalidJsonFormatException {
        String result = jsonTransformer.transform(json, null);
        if(result==null){
            throw new InvalidJsonFormatException();
        }
        return result;
    }
}
