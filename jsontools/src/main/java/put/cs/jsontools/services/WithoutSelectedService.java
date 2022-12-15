package put.cs.jsontools.services;

import put.cs.jsontools.exceptions.InvalidJsonFormatException;


public interface WithoutSelectedService {
    String getWithoutSelectedJson(String json, String keys) throws InvalidJsonFormatException;
}
