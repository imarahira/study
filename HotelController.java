package com.kumajakehour.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kumajakehour.mybatis.bean.entity.hotel.EmptyHotelSearch;
import com.kumajakehour.mybatis.bean.entity.hotel.HotelDataBean;
import com.kumajakehour.mybatis.bean.entity.hotel.HotelInfoSearch;
import com.kumajakehour.mybatis.bean.entity.hotel.HotelReserveData;
import com.kumajakehour.mybatis.bean.form.HotelForm;
import com.kumajakehour.service.HotelService;

@Controller
@RequestMapping("hotel")
public class HotelController {

	@Autowired
	private HotelService service;

	/**
	 * ホテル一覧ページ
	 * 
	 * @return HotelsAndGoodsView.swift
	 */
	@RequestMapping("/")
	public String HotelsAndGoodsView(Model model, HotelForm form) {

		/* FormからEntityへ詰め替える */
		EmptyHotelSearch emptyHotelSearch = new EmptyHotelSearch();
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date stayDate = sdFormat.parse(form.getStayDate());
			emptyHotelSearch.setStayDate(stayDate);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		emptyHotelSearch.setStayCount(Integer.valueOf(form.getStayCount()));
		emptyHotelSearch.setDateCount(Integer.valueOf(form.getDateCount()));

		/* 初期表示メソッドを呼び出す */
		List<HotelDataBean> hotelList = service.init(emptyHotelSearch);

		/* 取得した一覧を渡す */
		model.addAttribute("hotelList", hotelList);
		/* 画面遷移パラメータを渡す */
		model.addAttribute("form", form);

		return "HotelsAndGoodsView.swift";
	}

	/**
	 * ホテル詳細ページ
	 * 
	 * @return HotelsAndGoodsView.swift
	 */
	@RequestMapping("/hotelinfo")
	public String HotelInfoView(Model model, HotelForm form) {

		/* FormからEntityへ詰め替える */
		HotelInfoSearch hotelInfoSearch = new HotelInfoSearch();
		hotelInfoSearch.setHotelId(Integer.valueOf(form.getHotelId()));

		/* 宿詳細取得メソッドを呼び出す */
		List<HotelInfoSearch> hotelInfoSearchList = service.hotelInfo(hotelInfoSearch);

		/* 取得した一覧を渡す */
		model.addAttribute("hotelInfoSearchList", hotelInfoSearchList);
		/* 画面遷移パラメータを渡す */
		model.addAttribute("form", form);

		return "HotelInfoView.swift";
	}

	/**
	 * ホテル予約ページ
	 * 
	 * @return HotelReserveView.swift
	 */
	@RequestMapping("/hotelreserve")
	public String hotelReserveView(Model model, HotelForm form) {

		return "HotelReserveView.swift";
	}
	
	/**
	 * ホテル予約完了ページ
	 * 
	 * @return HotelReserveCompletionView.swift
	 */
	@RequestMapping("/hotelreservecompletion")
	public String hotelReserveCompletionView(Model model, HotelForm form) {
		
		/* FormからEntityへ詰め替える */
		HotelReserveData hotelReserveData = new HotelReserveData();
		BeanUtils.copyProperties(form, hotelReserveData);
		try {
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date stayDate = sdFormat.parse(form.getStayDate());
			hotelReserveData.setStayDate(stayDate);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		hotelReserveData.setStayCount(Integer.valueOf(form.getStayCount()));
		hotelReserveData.setDateCount(Integer.valueOf(form.getDateCount()));
		
		/* 予約メソッドを呼び出す */
		String result = service.reserveComp(hotelReserveData);
		
		return "HotelReserveCompletionView.swift";
	}

}