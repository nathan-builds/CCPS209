/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6done;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author n.hans
 */
public class WordCount extends FileProcessor<List<Integer>> {
    
    

    private int characterCount;
    private int wordCount;
    private int lineCount;

    @Override
    protected void startFile() {
        characterCount = 0;
        wordCount = 0;
        lineCount = 0;
    }

    @Override
    protected void processLine(String line) {

        lineCount += 1;

        String words[] = line.split("\\s+");
        wordCount += words.length;

        for (int i = 0; i < line.length(); i++) {
            characterCount += 1;
        }

    }

    @Override
    protected List<Integer> endFile() {

        LinkedList result = new LinkedList();
        result.add(characterCount);
        result.add(wordCount);
        result.add(lineCount);
        return result;

    }

}
