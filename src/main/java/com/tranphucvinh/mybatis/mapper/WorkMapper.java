package com.tranphucvinh.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tranphucvinh.mybatis.entity.Work;

@Mapper
public interface WorkMapper {

	int selectWorksTotCnt(Map<String, Object> param);

	List<Work> selectWorks(Map<String, Object> param);
}
