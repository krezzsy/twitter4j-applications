package com.krezzsy.twitter.oauth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.krezzsy.twitter.bean.Account;

public class OAuth {
	private final static String CONSUMER_KEY = "key";
	private final static String CONSUMER_SECRET = "secret";
	private static final String ACCESS_TOKEN = "token";
	private static final String ACCESS_TOKEN_SECRET = "token_secret";
	private static final String POST_QUERY = "WEB-INF/jsp/post.jsp";

	public void oauthorization(HttpServletRequest request, HttpServletResponse response) {
		String consumerKey = request.getParameter(CONSUMER_KEY);
		String consumerSecret = request.getParameter(CONSUMER_SECRET);
		String accessToken = request.getParameter(ACCESS_TOKEN);
		String accessTokenSecret = request.getParameter(ACCESS_TOKEN_SECRET);

		boolean result = checkTokens(consumerKey, consumerSecret, accessToken, accessTokenSecret);

		if (result) {
			try {

				Account account = new Account(consumerKey, consumerSecret, accessToken, accessTokenSecret);
				HttpSession session = request.getSession();
				session.setAttribute("account", account);
				request.getRequestDispatcher(POST_QUERY).forward(request, response);
			} catch (ServletException | IOException e) {

				e.printStackTrace();
			}
		} else {

			request.setAttribute("errorMessage", "Wrong data!");

			try {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		}
	}

	public boolean checkTokens(String consumerKey, String consumerSecret, String accessToken,
			String accessTokenSecret) {

		if (consumerKey.isEmpty() || consumerKey == null || consumerSecret.isEmpty() || consumerSecret == null) {
			System.out.println("No such pair consumer key and secret");
			return false;
		} else if (accessToken.isEmpty() || accessToken == null || accessTokenSecret.isEmpty()
				|| accessTokenSecret == null) {
			System.out.println("No such pair access token key and secret");
			return false;
		}
		if (consumerKey.length() != 25 || consumerSecret.length() != 50) {
			System.out.println("No such pair consumer key and secret");
			return false;
		}
		if (accessToken.length() != 50 || accessTokenSecret.length() != 45) {
			System.out.println("No such pair access token key and secret");
			return false;
		}
		return true;
	}

}
