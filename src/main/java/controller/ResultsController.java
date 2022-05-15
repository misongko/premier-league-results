package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import model.vo.Results;

public class ResultsController {
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\dev\\chromedriver\\101\\chromedriver.exe";
	
	HashMap <String, List<Results>> matchResults = new HashMap<>(); // key-팀명, value-경기결과리스트
	
	List<Results> arsenal = new ArrayList<>();
	List<Results> astonVilla = new ArrayList<>();
	List<Results> brentford = new ArrayList<>();
	List<Results> brighton = new ArrayList<>();
	List<Results> burnley = new ArrayList<>();
	List<Results> chelsea = new ArrayList<>();
	List<Results> crystalPalace = new ArrayList<>();
	List<Results> everton = new ArrayList<>();
	List<Results> leeds = new ArrayList<>();
	List<Results> leicester = new ArrayList<>();
	List<Results> liverpool = new ArrayList<>();
	List<Results> manUtd = new ArrayList<>();
	List<Results> manCity = new ArrayList<>();
	List<Results> newcastle = new ArrayList<>();
	List<Results> norwich = new ArrayList<>();
	List<Results> southampton = new ArrayList<>();
	List<Results> spurs = new ArrayList<>();
	List<Results> watford = new ArrayList<>();
	List<Results> westHam = new ArrayList<>();
	List<Results> wolves= new ArrayList<>();
	

	public HashMap <String, List<Results>> crawling() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		// WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless"); // 브라우저 띄우지 않음
		
		// WebDriver 객체 생성 - 설정한 옵션 대입   
		ChromeDriver driver = new ChromeDriver(options);
		
		String url = "https://www.premierleague.com/results"; // 크롤링 할 사이트
		driver.get(url); 
		
		// 페이지 로딩 대기
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 쿠키 창 accept 클릭
		driver.findElement(By.cssSelector("body > div.tcf-cmp._1Qu7MokjMuBXLOM2oKVLhZ._3_H6MsAd1grAO7T3v2WdhQ > div > div > div._1QkG3L-zAijqYlFASTvCtT > div._24Il51SkQ29P1pCkJOUO-7 > button._2hTJ5th4dIYlveipSEMYHH.BfdVlAo_cgSVjDUegen0F.js-accept-all-close")).click();

		// 스크롤 내리기
		for(int i = 0; i < 50; i++) {
			driver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 경기별
		for(WebElement match : driver.findElements(By.className("matchFixtureContainer"))){
			String[] matchInfo = match.getText().split("\n");
		
			String homeTeam = matchInfo[0];
			String[] score = matchInfo[1].split("-");
			int homeScore = Integer.parseInt(score[0]);
			int awayScore = Integer.parseInt(score[1]);
			
			String awayTeam = matchInfo[2];
			
			String[] stadiumInfo = match.getAttribute("data-venue").split(",");
			String stadium = stadiumInfo[0];
			
			char homeField = 'H';
			char awayField = 'A';
			
			// 홈 경기를 한 경우, Results객체의 opposingTeam변수에 awayTeam값 대입
			switch(homeTeam) {
			case "Arsenal":
				arsenal.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Aston Villa":
				astonVilla.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Brentford":
				brentford.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Brighton":
				brighton.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Burnley":
				burnley.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Chelsea":
				chelsea.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Crystal Palace":
				crystalPalace.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Everton":
				everton.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Leeds":
				leeds.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Leicester":
				leicester.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Liverpool":
				liverpool.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Man City":
				manCity.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Man Utd":
				manUtd.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Newcastle":
				newcastle.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Norwich":
				norwich.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Southampton":
				southampton.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Spurs":
				spurs.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Watford":
				watford.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "WestHam":
				westHam.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			case "Wolves":
				wolves.add(new Results(awayTeam, homeScore, awayScore, stadium, homeField)); break;
			}
			
			// 어웨이 경기를 한 경우, Results객체의 opposingTeam변수에 homeTeam값 대입
			switch(awayTeam) {
			case "Arsenal":
				arsenal.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Aston Villa":
				astonVilla.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Brentford":
				brentford.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Brighton":
				brighton.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Burnley":
				burnley.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Chelsea":
				chelsea.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Crystal Palace":
				crystalPalace.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Everton":
				everton.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Leeds":
				leeds.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Leicester":
				leicester.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Liverpool":
				liverpool.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Man City":
				manCity.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Man Utd":
				manUtd.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Newcastle":
				newcastle.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Norwich":
				norwich.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Southampton":
				southampton.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Spurs":
				spurs.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Watford":
				watford.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "WestHam":
				westHam.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			case "Wolves":
				wolves.add(new Results(homeTeam, awayScore, homeScore, stadium, awayField)); break;
			}
		}
		
		matchResults.put("Arsenal", arsenal);
		matchResults.put("Aston Villa", astonVilla);
		matchResults.put("Brentford", brentford);
		matchResults.put("Brighton", brighton);
		matchResults.put("Burnley", burnley);
		matchResults.put("Chelsea", chelsea);
		matchResults.put("Crystal Palace", crystalPalace);
		matchResults.put("Everton", everton);
		matchResults.put("Leeds", leeds);
		matchResults.put("Leicester", leicester);
		matchResults.put("Liverpool", liverpool);
		matchResults.put("Man City", manCity);
		matchResults.put("Man Utd", manUtd);
		matchResults.put("Newcastle", newcastle);
		matchResults.put("Norwich", norwich);
		matchResults.put("Southampton", southampton);
		matchResults.put("Spurs", spurs);
		matchResults.put("Watford", watford);
		matchResults.put("WestHam", westHam);
		matchResults.put("Wolves", wolves);
		
		return matchResults;
	}
}
