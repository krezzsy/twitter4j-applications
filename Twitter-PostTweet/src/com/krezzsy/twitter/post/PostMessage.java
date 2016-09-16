package com.krezzsy.twitter.post;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.krezzsy.twitter.bean.Account;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class PostMessage {
	private static final String MESSAGE = "message";
	private static final String ACCOUNT = "account";

	public void postTweet(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		Account account = (Account) session.getAttribute(ACCOUNT);

		String message = request.getParameter(MESSAGE);
		String consumerKey = account.getConsumerKey();
		String consumerSecret = account.getConsumerSecret();
		String accessToken = account.getAccessToken();
		String accessTokenSecret = account.getAccessTokenSecret();
		System.out.println(message + consumerKey + consumerSecret + accessToken + accessTokenSecret);
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();

		configurationBuilder.setDebugEnabled(true);

		configurationBuilder.setOAuthConsumerKey(consumerKey);
		configurationBuilder.setOAuthConsumerSecret(consumerSecret);
		configurationBuilder.setOAuthAccessToken(accessToken);
		configurationBuilder.setOAuthAccessTokenSecret(accessTokenSecret);

		Configuration configuration = configurationBuilder.build();

		Twitter twitter = new TwitterFactory(configuration).getInstance();
		Status status;
		try {
			status = twitter.updateStatus(message);
			System.out.println("Your tweet was successfully posted!");
			response.sendRedirect("https://twitter.com");
		} catch (TwitterException | IOException e) {
			e.printStackTrace();
		}

	}

}
