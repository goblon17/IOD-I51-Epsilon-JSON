package put.cs.jsontools.services;

import put.cs.jsontools.exceptions.InvalidJsonFormatException;

public interface MinifierService {
    String getMinificatedJson(String json) throws InvalidJsonFormatException;
}
