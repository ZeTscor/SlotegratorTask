package ui.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;

@Tag("UI")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/adminPanel.feature"},
        glue = {"ui.test"})
@Tag("UI")
public class RunCucumberTest {
}
