package Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
   //path of feature file
   features = "src/test/java/Cucumber",
   //path of step definition file
   glue = "stepDefination",
   monochrome = true,plugin= {"html:target/cucumber.html"}
   
   )
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
