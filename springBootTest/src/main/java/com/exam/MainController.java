package com.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exam.domain.Item;
import com.exam.repository.ItemRepository;


@Controller
@RequestMapping("/")
public class MainController {
	static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ItemRepository itemRepository;
	
	/*@RequestMapping
	@ResponseBody
	public String index() {
		return "Hello Spring Boot";
	}*/
	
	@RequestMapping
	@Transactional
	public ModelAndView index() {
		logger.debug("logger Test : {}", "logger Input Test");
		
		List<Item> items = itemRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
		Map<String, Object> map = new HashMap<>();
		map.put("items",  items);
		return new ModelAndView("index", map);
	}
}
