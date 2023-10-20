package com.study.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.mybatis.bean.entity.InitSearchBean;

@Mapper
public interface StudyMapper {
	
	InitSearchBean initSearch(@Param("cond") InitSearchBean param);

}
