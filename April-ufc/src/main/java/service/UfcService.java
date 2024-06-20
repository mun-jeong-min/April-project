package service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class UfcService {
    public static void main(String[] args) {
        String url = "https://kr.ufc.com/rankings";
        try {

            List<String> rankings = null;
            List<String> players = null;

            Document doc = Jsoup.connect(url).get();

            Elements newsHeadlines = doc.select(".view-content");
            for (Element headline : newsHeadlines) {
                Elements e = headline.getElementsByClass("view-grouping");
                rankings = e.get(0).getElementsByClass("views-field views-field-weight-class-rank").eachText();
                players = e.get(0).getElementsByClass("views-field views-field-title").eachText();
            }

            for(int i = 0; i < 15; i++) {
                System.out.println("랭킹 : " + (rankings != null ? rankings.get(i) : null) + "\n"
                        + " 이름 : " + (players != null ? players.get(i) : null));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
