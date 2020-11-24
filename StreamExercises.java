/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab10done;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author n.hans
 */
public class StreamExercises {

    public static int countLines(Path path, int thres) throws IOException {
        Stream<String> stream = Files.lines(path);
        Stream<String> newStream = stream.filter(str -> str.length() > thres);
        return (int) newStream.count();
    }

    public static List<String> collectWords(Path path) throws IOException {
        Stream<String> stream = Files.lines(path);
        List<String> answer = stream
                .map(str -> str.split(" "))
                .flatMap(x -> Arrays.stream(x)
                .filter(s -> s.length() > 0))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return answer;
    }
}
