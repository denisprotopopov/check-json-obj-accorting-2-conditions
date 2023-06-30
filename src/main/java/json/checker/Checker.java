package json.checker;

public class Checker {

  public Boolean check(Condition condition) {
    Boolean fin_result = null;
    for (Object o: condition.checks) {
      Boolean result;
      if ( o instanceof Condition) {
        result = check((Condition) o);
      } else {
        return makeOperation(condition.checks.get(0), condition.checks.get(1) , condition.operation);
      }
      fin_result = makeOperation(fin_result, result, condition.operation);
    }
    System.out.println("Fin Result: " + fin_result);
    return fin_result;
  }

  Boolean makeOperation(Boolean a, Boolean b, String o) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    if (o.equals("and")) {
      return a && b;
    }
    return a || b;
  }

  Boolean makeOperation(Object field, Object value, String op) {
    // TODO implement real checking
    System.out.println("Make operation: "+field+" " + op + " " +value);
    return true;
  }
}
