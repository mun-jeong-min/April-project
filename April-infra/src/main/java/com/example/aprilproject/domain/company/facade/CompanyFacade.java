package com.example.aprilproject.domain.company.facade;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;

@Component
public class CompanyFacade {

    public CikCodeDto getCikCode(String name){
        CikCodeDto cikCodeDto = new CikCodeDto();

        try {
            Document doc = Jsoup.connect("https://www.sec.gov/files/company_tickers.json")
                    .ignoreContentType(true) // JSON 컨텐츠 타입 허용
                    .execute()
                    .parse();

            // JSON 문자열 얻기
            String jsonStr = doc.body().text();

            // Jackson ObjectMapper로 JSON 파싱
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonStr);

            // 검색어를 소문자로 변환
            name = name.toLowerCase();

            // JSON 객체를 순회하며 검색
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode company = elements.next();
                String ticker = company.get("ticker").asText().toLowerCase();

                if (ticker.contains(name)) {
                    cikCodeDto = new CikCodeDto(
                            company.get("cik_str").asInt(),
                            company.get("ticker").asText(),
                            company.get("title").asText()
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cikCodeDto;
    }

    public CompanyDto getCompanyInfo(int cikCode) {
        String url = String.format("https://data.sec.gov/submissions/CIK%010d.json", cikCode);
        String tenKDate = "";
        String tenKNumber = "";
        String eightKDate = "";
        String eightKNumber = "";
        String def14ADate = "";
        String def14ANumber = "";
        try {
            String jsonContent = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .execute()
                    .body();

            // JSON 파싱
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonContent);

            // filings 섹션의 recent 배열 가져오기
            JsonNode form = rootNode.path("filings").path("recent").path("form");
            JsonNode reportDate = rootNode.path("filings").path("recent").path("reportDate");
            JsonNode accentNumber = rootNode.path("filings").path("recent").path("accessionNumber");

            // form이 "10-K"인 인덱스 찾기
            for (int i = 0; i < form.size(); i++) {
                if (form.get(i).asText().equals("10-K") && tenKDate.equals("")) {
                    tenKDate = reportDate.get(i).asText();
                    tenKNumber = accentNumber.get(i).asText();
                }
                if (form.get(i).asText().equals("8-k") && eightKDate.equals("")) {
                    eightKDate = reportDate.get(i).asText();
                    eightKNumber = accentNumber.get(i).asText();
                }
                if (form.get(i).asText().equals("DEF 14A") && def14ADate.equals("")) {
                    def14ADate = reportDate.get(i).asText();
                    def14ANumber = accentNumber.get(i).asText();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new CompanyDto(tenKDate, tenKNumber, eightKDate, eightKNumber, def14ADate, def14ANumber);
    }
}
