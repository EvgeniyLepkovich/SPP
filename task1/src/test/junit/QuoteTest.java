package junit;

import by.bsuir.entity.Quote;
import org.junit.Assert;
import org.junit.Test;

public class QuoteTest {

    @Test
    public void testGetRandomQuote() {
        Quote quote = new Quote();
        for (int i = 0; i < 10000; i++){
            Assert.assertNotNull(quote.getRandomQuote());
        }
    }
}