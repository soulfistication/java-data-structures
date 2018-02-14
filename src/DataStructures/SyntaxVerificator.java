/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 *
 * @author Ivan Almada
 */

public class SyntaxVerificator {
    public static Set readWords(Reader in, int n) throws IOException {
        Set result = new Set(n);
        StreamTokenizer tok = new StreamTokenizer(in);
        
        tok.ordinaryChar('.');
        tok.lowerCaseMode(true);
        int c = tok.nextToken();
        while (c != StreamTokenizer.TT_EOF) {
            if (c == StreamTokenizer.TT_WORD) {
                result.add(tok.sval);
            }
            c = tok.nextToken();
        }
        return result;
    }
}
