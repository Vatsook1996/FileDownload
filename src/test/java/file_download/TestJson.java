package file_download;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

    public class TestJson {
        public ClassLoader cl = TestJson.class.getClassLoader();

        @DisplayName("Проверка содержимого файла json")
        @Test
        void jsonTest() throws Exception {
            ObjectMapper objectMapper = new ObjectMapper();
            try (InputStream is = cl.getResourceAsStream("test.json")) {
                assert is != null;
                try (InputStreamReader isr = new InputStreamReader(is)) {
                    modal.TestJson testJson = objectMapper.readValue(isr, modal.TestJson.class);
                    Assertions.assertEquals("George", testJson.getName());
                    Assertions.assertEquals(27, testJson.getAge());
                    Assertions.assertEquals("Parrot", testJson.getPets().get(0).getAnimal());
                    Assertions.assertEquals("Anthony", testJson.getPets().get(1).getPetsName());
                }
            }
        }
    }
