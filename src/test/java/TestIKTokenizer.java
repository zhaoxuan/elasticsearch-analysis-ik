import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by john on 19/11/2016.
 */
public class TestIKTokenizer {
    @Test
    public void testIKTokenizer() throws IOException {
        String text = "白富美";

        Configuration configuration = new Configuration();
        IKAnalyzer analyzer = new IKAnalyzer(configuration);
        Reader reader = new StringReader(text);

        TokenStream stream = analyzer.tokenStream(null, reader);

        CharTermAttribute charTermAttribute = stream.getAttribute(CharTermAttribute.class);

        stream.reset();

        while (stream.incrementToken()) {
            System.out.print("[" + charTermAttribute + "] ");
        }


    }
}
