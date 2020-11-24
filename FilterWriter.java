/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab26done;

import java.io.IOException;
import java.io.Writer;
import java.util.function.BiPredicate;

/**
 *
 * @author n.hans
 */
public class FilterWriter extends Writer {

    private Writer writer;
    private BiPredicate<Character, Character> pred;
    private char previous;

    public FilterWriter(Writer writer, BiPredicate<Character, Character> pred,
            char prev) {
        this.writer = writer;
        this.pred = pred;
        this.previous = previous;
    }

    @Override
    public void write(char[] data, int off, int len) throws IOException {
        for (int i = off; i <= len; i++) { // might have to adjust number or position of where it starts reading characters
            char c = data[i];
            if (pred.test(previous, c)) {
                writer.write(c);
                previous = c;

            }
        }
    }

    @Override
    public void close() throws IOException {
        writer.close();

    }

    @Override
    public void flush() throws IOException {
        writer.flush();

    }

}
