package org.perscholas.practicetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView response = new ModelAndView();
		response.setViewName("index/index");



		//if there is a value in the session print it
		Object firstName = session.getAttribute("firstName");
		System.out.println(firstName);

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				String value = cookies[i].getValue();
				System.out.println("Cookie: " + name + " = " + value);
			}
		} else {
			System.out.println("No cookies on request");
		}

		return response;
	}

	@RequestMapping(value = "/indexSubmit", method = RequestMethod.GET)
	public ModelAndView indexSubmit(HttpServletRequest request, HttpSession session) throws Exception {
		String firstName = request.getParameter("FirstName");

		System.out.println("name = " + firstName);
		System.out.println("sports = " + request.getParameter("sports"));


		//put value in the session
		session.setAttribute("firstName", "putting first name in session " + firstName);
		ModelAndView response = new ModelAndView(); //used by spring to render jsp page
		response.addObject("firstNameHere", firstName); //attribute that will be used in jsp to display first name
		response.setViewName("indexSubmit");

		return response;
	}
	
}
