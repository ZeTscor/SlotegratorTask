package ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features/adminPanel.feature"},
        glue = {"ui.test"})

public class RunCucumberTest {
}
