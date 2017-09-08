package com.citi.dde.achweb.config;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.web.servlet.DispatcherServlet;

@WebServlet(name ="spring-mvc" ,urlPatterns = {"/"}, asyncSupported = true, loadOnStartup=1)
public class AchServlet  extends DispatcherServlet{

	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AchServlet() {
        super();
    }
	
}
