package view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import controller.ResultsController;
import model.vo.Results;

public class ResultsView {
	private Scanner sc = new Scanner(System.in);
	
	private ResultsController resultsController = new ResultsController();
	private HashMap <String, List<Results>> matchResults = resultsController.crawling();
	
	public void viewTeamResults() {
		while(true) {
			System.out.println("어떤 팀의 경기 결과를 확인하시겠습니까? ");
			String inputTeam = sc.nextLine();
			
			System.out.println("======= [ " + inputTeam + " ] 경기 결과 =======");
			System.out.println("최근 경기순으로 보여집니다.\n");
			for (int i = 0; i < matchResults.get(inputTeam).size(); i++) {
				if(matchResults.get(inputTeam).get(i).getField() == 'H')
					System.out.printf(">> %2d. %s %d:%d %s,\n\t  %s\n\n",
										(i + 1),    	
										inputTeam, 
										matchResults.get(inputTeam).get(i).getMyScore(), 
										matchResults.get(inputTeam).get(i).getOpposingScore(),
										matchResults.get(inputTeam).get(i).getOpposingTeam(),
										matchResults.get(inputTeam).get(i).getStadium()
										);
				else if((matchResults.get(inputTeam).get(i).getField() == 'A'))
					System.out.printf(">> %2d. %s %d:%d %s,\n\t  %s\n\n", 
										(i + 1), 
										matchResults.get(inputTeam).get(i).getOpposingTeam(), 
										matchResults.get(inputTeam).get(i).getOpposingScore(),
										matchResults.get(inputTeam).get(i).getMyScore(), 
										inputTeam,
										matchResults.get(inputTeam).get(i).getStadium()
										);
			}
			System.out.println();
			viewTeamRecord(inputTeam);
			
		}
	}

	public void viewTeamRecord(String inputTeam) {
		System.out.println(inputTeam + "과(와) 어떤 팀과의 전적을 확인하시겠습니까? ");
		String inputOpposingTeam = sc.nextLine();
		
		System.out.println("==== [ " + inputTeam + " ] vs [ " + inputOpposingTeam + " ] 경기 결과 ====");
		System.out.println("최근 경기순으로 보여집니다.\n");
		for(int i = 0 ; i < matchResults.get(inputTeam).size(); i++) {
			if(matchResults.get(inputTeam).get(i).getOpposingTeam().equals(inputOpposingTeam)) {
				if(matchResults.get(inputTeam).get(i).getField() == 'H') {
					System.out.println("------ " + inputTeam + "의 [홈] 경기" + " ------");
					System.out.printf(">> %2d. %s %d:%d %s,\n\t  %s\n\n",
							(i + 1), 
							inputTeam, 
							matchResults.get(inputTeam).get(i).getMyScore(), 
							matchResults.get(inputTeam).get(i).getOpposingScore(),
							matchResults.get(inputTeam).get(i).getOpposingTeam(),
							matchResults.get(inputTeam).get(i).getStadium()
							);
				}
				else if((matchResults.get(inputTeam).get(i).getField() =='A')) {
					System.out.println("------ " + inputTeam + "의 [어웨이] 경기" + " ------");
					System.out.printf(">> %2d. %s %d:%d %s,\n\t  %s\n\n", 
							(i + 1), 
							matchResults.get(inputTeam).get(i).getOpposingTeam(), 
							matchResults.get(inputTeam).get(i).getOpposingScore(),
							matchResults.get(inputTeam).get(i).getMyScore(), 
							inputTeam,
							matchResults.get(inputTeam).get(i).getStadium()
							);
				}
				
			}
		}
	}
	
}
		
