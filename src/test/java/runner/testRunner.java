package runner;

import io.cucumber.testng.CucumberOptions;
import tests.testBase;

@CucumberOptions(features = "src\\test\\java\\features",glue = {"steps"},
plugin = { "pretty", "html:target/cucumber-reports"})
public class testRunner extends testBase {

}
