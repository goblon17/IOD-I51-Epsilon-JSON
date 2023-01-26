package put.cs.jsontools.transforms;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import put.cs.jsontools.exceptions.InvalidJsonFormatException;
import put.cs.jsontools.services.implementation.BeautifierServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BeautifierServiceImplTest {

    @Mock
    private static BeautifierTransformerImpl mockJsonTransformer;

    @InjectMocks
    private static BeautifierServiceImpl beautifierService;

    @BeforeAll
    public static void setup(){
        mockJsonTransformer = mock(BeautifierTransformerImpl.class);
        beautifierService = new BeautifierServiceImpl(mockJsonTransformer);
    }


    @Test
    public void testGetBeautifiedJson() throws InvalidJsonFormatException {
        String json = "{\"key\":\"value\"}";
        String beautifiedJson = "{\"key\":\"value\"}";
        when(mockJsonTransformer.transform(json, null)).thenReturn(beautifiedJson);

        String result = beautifierService.getBeautifiedJson(json);

        assertEquals(beautifiedJson, result);
    }

    @Test
    public void testGetBeautifiedJson_throwsException(){
        String json = "{\"key\":\"value\"}";

        when(mockJsonTransformer.transform(json, null)).thenThrow(InvalidJsonFormatException.class);
        assertThrows(InvalidJsonFormatException.class,()->{
        beautifierService.getBeautifiedJson(json);}
        );
    }
}