

import java.io.IOException;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Day01 {

  public int calibrateFrequency(String file) throws IOException {

    return Files.lines(Paths.get(file), StandardCharsets.UTF_8)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  public int calibrateFrequencyTwice(String file) throws IOException {
    ArrayList<Integer> freqChanges = new ArrayList<>();
    Files.lines(Paths.get(file), StandardCharsets.UTF_8)
        .mapToInt(Integer::parseInt)
        .forEach(freqChanges::add);

    HashSet<Integer> freqSet = new HashSet<>();
    int sum = 0;

    for (int i = 0; i < 200; i++) {
      for (int f : freqChanges) {
        sum += f;
        if (!freqSet.add(sum)) {
          return sum;
        }
      }
    }
    return 0;
//    Arrays.parallelPrefix(summedFreqs, Integer::sum);
//

//
//    for (int f : summedFreqs) {
//      if (!freqSet.add(f)) {
//        System.out.println(f);
//      }
//    }
//
//    return 0;
  }


}
