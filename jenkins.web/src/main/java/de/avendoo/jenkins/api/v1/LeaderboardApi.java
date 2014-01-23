package de.avendoo.jenkins.api.v1;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.avendoo.jenkins.domain.Leaderboard;
import de.avendoo.jenkins.properties.JenkinsProperties;
import de.avendoo.jenkins.rest.LeaderboardService;

@Controller
@RequestMapping("/api/v1/leaderboard")
public class LeaderboardApi {

	@Autowired
	private LeaderboardService service;
	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	@ResponseBody
	public Leaderboard getLeaderboard() {
		try {
			return service.getCiGame(JenkinsProperties.getInstance().getApiRoot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Leaderboard();
	}
}
