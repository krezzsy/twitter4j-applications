package com.krezzsy.twitter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krezzsy.twitter.oauth.OAuth;
import com.krezzsy.twitter.post.PostMessage;

public class Controller extends HttpServlet {
	private static final String COMMAND = "command";
	private static final String OAUTH = "oauth";
	private static final String POST = "post_tweet";
	private static final long serialVersionUID = -164524106663257926L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter(COMMAND);
		if (commandName.equals(OAUTH)) {
			new OAuth().oauthorization(request, response);
		} else if (commandName.equals(POST)) {
			new PostMessage().postTweet(request, response);
		}

	}
}
