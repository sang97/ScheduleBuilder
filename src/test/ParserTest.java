package test;

import student.TestCase;
import parser.HtmlParser;

public class ParserTest extends TestCase {
    HtmlParser parser;
    
    public void setUp() {
        parser = new HtmlParser();
    }
    
    public void test() {
        parser.beginParse();
    }
}
