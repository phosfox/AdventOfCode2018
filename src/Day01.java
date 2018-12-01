

import java.io.IOException;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;


public class Day01 {

  public int calibrateFrequency(String file) throws IOException {

    return Files.lines(Paths.get(file), StandardCharsets.UTF_8)
    .mapToInt(Integer::parseInt)
        .sum();
  }


}
