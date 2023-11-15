package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\HP\\eclipse-workspace-new\\Medicare-Cucumber_RestAssured\\src\\test\\java\\features\\medicare.feature",
				 glue= {"steps"},
				 plugin= {"html:target/Cucumberreport.html",
						 "pretty",
						"timeline:test-output-thread/"		
				}
			)
public class TestRunner {

}
