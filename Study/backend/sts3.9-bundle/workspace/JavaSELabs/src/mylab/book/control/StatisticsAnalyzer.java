package mylab.book.control;

import mylab.book.entity.Publication;
import mylab.book.entity.Novel;
import mylab.book.entity.Magazine;
import mylab.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications){
        Map<String, Integer> totalPriceMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for(Publication pub : publications){
            String type = getPublicationType(pub);
            totalPriceMap.put(type, totalPriceMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> avgPriceMap = new HashMap<>();
        for(String type : totalPriceMap.keySet()){
            avgPriceMap.put(type, totalPriceMap.get(type) / (double)countMap.get(type));
        }
        return avgPriceMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications){
        Map<String, Integer> countMap = new HashMap<>();
        for(Publication pub : publications){
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }
        int total = publications.length;
        Map<String, Double> distMap = new HashMap<>();
        for(String type : countMap.keySet()){
            distMap.put(type, countMap.get(type) * 100.0 / total);
        }
        return distMap;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year){
        int count = 0;
        for(Publication pub : publications){
            String pubYear = pub.getPublishDate().substring(0, 4);
            if(pubYear.equals(year)) count++;
        }
        return publications.length == 0 ? 0 : count * 100.0 / publications.length;
    }

    private String getPublicationType(Publication pub){
        if(pub instanceof Novel) return "소설";
        else if(pub instanceof Magazine) return "잡지";
        else if(pub instanceof ReferenceBook) return "참고서";
        else return "기타";
    }

    public void printStatistics(Publication[] publications){
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("[타입별 평균 가격]");
        Map<String, Double> avgPrice = calculateAveragePriceByType(publications);
        for(String type : avgPrice.keySet()){
            System.out.println(type + ": " + df.format(avgPrice.get(type)) + "원");
        }
        System.out.println("\n[출판물 유형 분포]");
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        for(String type : dist.keySet()){
            System.out.println(type + ": " + df.format(dist.get(type)) + "%");
        }
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n[2007년도 출판물 비율]: " + df.format(ratio2007) + "%");
    }
}
