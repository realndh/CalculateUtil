package me.dhlee.calculateutil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class Runner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[][] strArr = new String[100][1000];

        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                strArr[i][j] = (i + 1) * (j + 1) + "";
            }
        }

        Double min = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).min().getAsDouble();
        Double max = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).max().getAsDouble();
        Double sum = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).sum();
        Double avg = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).average().getAsDouble();

        log.info("min = {}, max = {}, sum = {}, avg = {}", min, max, sum, avg);
    }
}
