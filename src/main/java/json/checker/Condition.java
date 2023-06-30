package json.checker;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Condition {
  private Condition() {
  };
  List checks;
  String operation;

  public static ConditionBuilder builder() {
    return new Condition().new ConditionBuilder();
  }

  public class ConditionBuilder {
    private ConditionBuilder() {
    }

    ;

    public ConditionBuilder withChecks(List checks) {
      Condition.this.checks = checks;
      return this;
    }

    public ConditionBuilder withOperation(String operation) {
      Condition.this.operation = operation;
      return this;
    }

    public Condition build() {
      return Condition.this;
    }
  }
}

