package put.cs.jsontools.services;

import put.cs.jsontools.exceptions.InvalidJsonFormatException;

public interface OnlySelectedService {
    String getOnlySelectedJson(String json, String keys) throws InvalidJsonFormatException;
}
