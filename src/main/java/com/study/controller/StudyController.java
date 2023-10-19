package com.study.controller;
import static com.study.constants.StudyConstants.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(MAIN_URL)
public class StudyController {
	
	@Autowired
	private StudyService service;
	
	/**
	 * 初期画面表示
	 * 
	 * @return 初期画面
	 */
	@RequestMapping(INIT_SCREEN_URL)
	public String initScreenSet(Model model, Form form) {
		
		//formからentityに詰め替える
		InitSearchBean initSearchBean =new InitSearchBean();
		BeanUtils.copyPropeties(form, initSearchBean);
		
		//formを画面に渡す
		model.addAttribute("form", form);
		
		return TEMPLETE_PATH;
	}

}
