import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import json.checker.Checker;
import json.checker.Condition;

import java.time.LocalTime;
import java.util.Arrays;

public class Test3 {

  public static void main(String[] args) throws JsonProcessingException {
    Condition condition = Condition.builder()
            .withChecks(
                    Arrays.asList(
                            Condition.builder()
                                    .withChecks(Arrays.asList("msg_type", 200))
                                    .withOperation("=")
                                    .build(),
                            Condition.builder().withChecks(Arrays.asList(
                                            Condition.builder()
                                                    .withChecks(Arrays.asList("msg_type", 202))
                                                    .withOperation("=")
                                                    .build(),
                                            Condition.builder()
                                                    .withChecks(Arrays.asList("currency", "RUB"))
                                                    .withOperation("=")
                                                    .build()
                                    )).withOperation("or")
                                    .build()
                    )
            ).withOperation("and")
            .build();

    ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
    System.out.println(mapper.writeValueAsString(condition));
    System.out.println(LocalTime.now());
    System.out.println("Result: " + new Checker().check(condition));
    System.out.println(LocalTime.now());
  }





}

