package net.itspartner.test.n2;

import org.junit.Assert;
import org.junit.Test;

public class QueryExtractorTest extends Assert {
    @Test
    public void testExtract() {
        QueryExtractor queryExtractor = new QueryExtractor();
        String url = "http://itspartner.net/api?user=pavel&age=50";
        assertEquals("pavel",
                queryExtractor.extract(url,"user"));
        assertEquals("50",
                queryExtractor.extract(url,"age"));

        url = "http://itspartner.net/api?user=pavel&age=50&height=190";
        assertEquals("pavel",
                queryExtractor.extract(url,"user"));
        assertEquals("50",
                queryExtractor.extract(url,"age"));
        assertEquals("190",
                queryExtractor.extract(url,"height"));
    }
}
