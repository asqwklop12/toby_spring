package klom.pratice.toby_spring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

  public Integer fileReadTemplate(String filePath, BufferedReaderCallback callback)
      throws IOException {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(filePath));
      int ret = callback.doSomethingWithReader(br);
      return ret;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      throw e;
    } finally {
      try {
        if (br != null) {
          br.close();
        }
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

    }
  }

  public Integer calcSum(String filepath) throws IOException {
    BufferedReaderCallback sumCallback =
        br -> {
          int sum = 0;
          String line = null;
          while ((line = br.readLine()) != null) {
            sum += Integer.parseInt(line);
          }
          return sum;
        };
    return fileReadTemplate(filepath, sumCallback);
  }
}
