package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void systemPropertiesTest(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void systemProperties2Test(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }
    @Test
    @Tag("property")
    void systemProperties3Test(){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }

}
