package llm.llmanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={ "controller","service","util" })
public class LlmAnalysisApplication {

  public static void main(String[] args) {
    SpringApplication.run(LlmAnalysisApplication.class, args);
  }

}
