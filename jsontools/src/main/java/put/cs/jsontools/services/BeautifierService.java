package put.cs.jsontools.services;

import put.cs.jsontools.exceptions.InvalidJsonFormatException;

public interface BeautifierService {
    String getBeautifiedJson(String json) throws InvalidJsonFormatException;
}
