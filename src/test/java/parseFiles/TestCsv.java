package parseFiles;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestCsv {
    public ClassLoader cl = TestCsv.class.getClassLoader();


    @DisplayName("Чтение и проверка содержимого файла csv")
    @Test
    void csvParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("zip.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                if (entry.getName().contains("test.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zs));
                    List<String[]> content = csvReader.readAll();
                    Assertions.assertArrayEquals(new String[]{"1", "Barnard Higgins"}, content.get(0));
                }
            }
        }
    }
}


