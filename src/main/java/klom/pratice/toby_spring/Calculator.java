package klom.pratice.toby_spring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
  public Integer calcSum(String filepath) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(filepath));
    Integer sum = 0;
    String line = null;
    while ((line = br.readLine()) != null) {
      sum += Integer.parseInt(line);
    }
    br.close();
    return sum;
  }
}
