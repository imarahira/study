package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.mybatis.bean.entity.InitSearchBean;
import com.study.mybatis.mapper.StudyMapper;

@Service
public class StudyService {
	
	@Autowired
	private StudyMapper mapper;

	/**
	 * 初期画面表示メソッド
	 * 
	 * @return InitSearchBean
	 */
	public InitSearchBean initSearch(InitSearchBean param) {
		
		//検索結果用Beanをインスタンス
		InitSearchBean result = new InitSearchBean();
		
		//Mapper呼び出し
		result = mapper.initSearch(param);
		
	//取得結果を返す
	return result;
	}
	
}
