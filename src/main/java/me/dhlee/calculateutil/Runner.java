package me.dhlee.calculateutil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.DoubleStream;

@Component
@Slf4j
public class Runner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[][] strArr = new String[10][1];

        for (int i = 0; i < strArr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String separator = "";
            for (int j = 0; j < 10; j++) {
                stringBuilder.append(separator);
                stringBuilder.append(i * 10 + j + "");
                separator = ",";
            }
            strArr[i][0] = stringBuilder.toString();
        }

        DoubleStream doubleStream = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).flatMapToDouble(y -> Arrays.stream(y.split(",")).mapToDouble(Double::parseDouble)));
//        doubleStream.forEach(System.out::println);
        System.out.println(doubleStream.max().getAsDouble());

//        System.out.println(result);
//        Double min = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).min().getAsDouble();
//        Double max = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).max().getAsDouble();
//        Double sum = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).sum();
//        Double avg = Arrays.stream(strArr).flatMapToDouble(x -> Arrays.stream(x).mapToDouble(Double::parseDouble)).average().getAsDouble();
//
//        log.info("min = {}, max = {}, sum = {}, avg = {}", min, max, sum, avg);


    }
}
