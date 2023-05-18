package parseFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsontest.LaptopsData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonLaptopsTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("test.json");
             InputStreamReader isr = new InputStreamReader(is)
        ) {
            LaptopsData laptopsData = objectMapper.readValue(isr, LaptopsData.class);
            Assertions.assertEquals("512 gb", laptopsData.getSsd().get(0));
            Assertions.assertEquals("16 gb", laptopsData.getRam().getGrey());
        }
    }
}
