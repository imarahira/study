package com.example.demo.controller;
import static com.example.demo.constants.StudyConstants.*;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.study.mybatis.bean.entity.InitSearchBean;
import com.example.demo.mybatis.bean.form.StudyForm;
//import com.study.service.StudyService;

@Controller
//@RequestMapping(MAIN_URL)
public class StudyController {
	
//	@Autowired
//	private StudyService service;
	
	/**
	 * 初期画面表示
	 * 
	 * @return 初期画面
	 */
//	@GetMapping(INIT_SCREEN_URL)
	@GetMapping("/")
	public String initScreenSet(@ModelAttribute StudyForm form, Model model) {
		
//		//formからentityに詰め替える
//		InitSearchBean initSearchBean =new InitSearchBean();
//		
//		//Bean同士の同じフィールド名のものをコピーしてくれる
//		BeanUtils.copyProperties(form, initSearchBean);
//		
//		//Serviceメソッド呼び出し
//		initSearchBean = service.initSearch(initSearchBean);
		
		//formを画面に渡す
		model.addAttribute("form", form);
		
		//同期処理の場合、表示する画面のパスを返す
		return TEMPLETE_PATH;
	}

}
