package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static String toPrettyJson(Object object) {

        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            return object.toString();
        }
    }
}