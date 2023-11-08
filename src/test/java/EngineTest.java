import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.Engine.swap;

@SpringBootTest
public class EngineTest {

    @Test
    void swapTest() {
        String pathToJsonMap = "src/main/resources/jsonMap.json";
        String pathToYmlTemplate ="src/main/resources/swappedFile.yml";
        String pathToSwappedYml = "src/main/resources/template1.yml";

        try {
            swap(pathToJsonMap, pathToYmlTemplate, pathToSwappedYml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
