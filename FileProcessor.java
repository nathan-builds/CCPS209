/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6done;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author n.hans
 * @param <R>
 */
public abstract class FileProcessor<R> {

    protected abstract void startFile();

    protected abstract void processLine(String line);

    protected abstract R endFile();

    public final R processFile(BufferedReader in) throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            processLine(line);
        }

        startFile();
        return endFile();

    }

}
