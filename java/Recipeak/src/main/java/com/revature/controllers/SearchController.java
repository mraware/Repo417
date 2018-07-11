package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.SearchService;

@Controller
@RequestMapping(value="/search")
public class SearchController {
	ObjectMapper om = new ObjectMapper();
	Logger log = Logger.getLogger(SearchController.class);
	
	@Autowired
	SearchService ss;
	
}
