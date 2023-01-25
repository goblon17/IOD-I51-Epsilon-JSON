package put.cs.jsontools.transforms;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeautifierTransformerImplTest {

    private BeautifierTransformerImpl transformer = new BeautifierTransformerImpl();

    @Test
    public void testTransform() {
        String json = "{\"InsuranceCompanies\":{\"source\":\"investopedia.com\"}}";
        String expected = "{\n" +
                "  \"InsuranceCompanies\" : {\n" +
                "    \"source\" : \"investopedia.com\"\n" +
                "  }\n" +
                "}";

        String result = transformer.transform(json, null);
        Assertions.assertThat(expected).isEqualToNormalizingNewlines(result);
    }

    @Test
    public void testTransformWithInvalidJson() {
        String json = "invalid json";
        String result = transformer.transform(json, null);
        assertNull(result);
    }

    @Test
    public void testTransformWithNullJson() {
        String json = null;
        assertThrows(IllegalArgumentException.class, ()->{
            transformer.transform(json, null);
        });
    }
}