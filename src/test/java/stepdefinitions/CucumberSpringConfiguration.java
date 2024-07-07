package stepdefinitions;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import config.SpringConfig;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringConfig.class)
public class CucumberSpringConfiguration {
    // Kosongkan kelas ini, karena ini hanya untuk konfigurasi konteks
}