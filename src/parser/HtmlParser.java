package parser;

import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import model.Course;

public class HtmlParser {
    public void parseCourse(Element tablerow) {
        Elements entries = tablerow.getElementsByClass("pldefault");
        switch (entries.size()) {
            case 0:
                System.out.println("Header");
                return;
            case 2:
                System.out.println("Comments");
                return;
            default:
        }

        try {
            int colspan = 1;
            String crn = entries.get(0).child(1).text();
            String course = entries.get(1).child(0).text();
            String title = entries.get(2).text();
            String type = entries.get(3).text();
            String cr_hrs = entries.get(4).text();
            String seats = entries.get(5).child(0).child(0).text();
            String capacity = entries.get(6).text();
            String instructor = entries.get(7).text();
            String days = entries.get(8).text();
            String begin = "(ARR)";
            String end = "(ARR)";
            if (!entries.get(9).hasAttr("colspan")) {
                colspan = 0;
                begin = entries.get(9).text();
                end = entries.get(10).text();
            }
            String location = entries.get(11 - colspan).text();
            String exam = entries.get(12 - colspan).text();
            
            System.out.println(crn + " " + course + " " + title + " " + begin);
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void beginParse() {
        try {
            File input = new File("extras/timetable.html");
            Document doc = Jsoup.parse(input, "UTF-8");
            
            Elements tables = doc.getElementsByClass("plaintable");
            Element table = tables.iterator().next().child(0);
            for (Element tablerow: table.children()) {
                parseCourse(tablerow);
            }
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
