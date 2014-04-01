package de.atomfrede.jenkins.rest;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import de.atomfrede.jenkins.domain.Leaderboard;
import de.atomfrede.jenkins.domain.Participant;


@Component
public class LeaderboardService {

	public Leaderboard getCiGame(String apiRoot) throws IOException {
		Leaderboard board = new Leaderboard();
		String url = apiRoot+"/cigame";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements tableRows = doc.select(".bigtable tr");
		
		boolean skip = true;
		for(Element tableRow:tableRows){
			if(!skip) {
				Participant p = extractParticipantOfRow(tableRow);
				board.addParticipant(p);
			}
			skip = false;
		}

		return board;
	}
	
	private Participant extractParticipantOfRow(Element tableRow) {
		Elements tableCells = tableRow.select("td");
		
		Participant p = new Participant();
		
		int counter = 0;
		for(Element tableCell:tableCells) {
			switch (counter) {
			case 0:
				//User Avatarimage
				p.setUserImage(tableCell.select("img").attr("src"));
				break;
			case 1:
				//User
				p.setFullname(tableCell.select("a").text());
				break;
			case 2:
				break;
			case 3:
				//Score
				p.setScore(tableCell.text());
				break;
			default:
				break;
			}
			counter++;
		}
		return p;
	}
}
