package com.tranphucvinh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranphucvinh.exception.BadRequestException;
import com.tranphucvinh.jpa.repository.UserRepository;
import com.tranphucvinh.jpa.repository.WorkRepository;
import com.tranphucvinh.mybatis.entity.Work;
import com.tranphucvinh.mybatis.mapper.UserMapper;
import com.tranphucvinh.mybatis.mapper.WorkMapper;
import com.tranphucvinh.utils.Utils;

@Service
public class TodoService {
	
	@Resource
	private WorkMapper workMapper;
	
	@Resource
	private UserMapper userMapper;

	@Autowired
	private WorkRepository workRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private List<Work> list;
	
	/**
	 * get works pagination
	 * @param param
	 * @return
	 */
	public Map<String,Object> getWorks(Map<String, Object> param) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		String page = (String) param.get("page");
		String sizeOfPage = (String) param.get("sizeOfPage");
		int pageInt = 0;
		int lastPage = 0;

		// get list of page
		if(Utils.isInteger(page) && Utils.isInteger(sizeOfPage)) {
			
			pageInt = Integer.parseInt(page);
			if(pageInt <= 0) {
				throw new BadRequestException("Page number cannot be less than or equal zero.");
			}

			int sizeOfPageInt = Integer.parseInt(sizeOfPage);
			if(sizeOfPageInt <= 0) {
				throw new BadRequestException("Size of page cannot be less than or equal zero.");
			}

			int totalWorks = workMapper.selectWorksTotCnt(param);
			lastPage = totalWorks/sizeOfPageInt + ((totalWorks%sizeOfPageInt)>0?1:0);
			
			if(pageInt>lastPage) {
				throw new BadRequestException("The specified page exceeds the limit");
			} else {
				int startWork = (pageInt-1)*sizeOfPageInt;
				param.put("start_work", startWork);
				list = workMapper.selectWorks(param);

				result.put("page_of_list", pageInt);
				result.put("last_page", lastPage);
			}
		} else {
			throw new BadRequestException("Page and sizeOfPage must be is number !");
		}

		result.put("list", getDetailWork(list));
		return result;
	}

	private List<Work> getDetailWork(List<Work> works) {
		if(works.isEmpty()) {
			return new ArrayList<Work>();
		}
		for(Work e:works) {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("work_id", e.work_id);
			e.setUser(userMapper.selectUsers(param));
		}
		return works;
	}
	
	public void saveWork(com.tranphucvinh.jpa.model.Work work) {
		workRepository.save(work);
	}
	
	public void deleteWorkById(Long id) {
		workRepository.deleteById(id);
	}
	
	public boolean isNotEmptyUserId(Long id) {
		return userRepository.countById(id)>0;
	}
	public void updateWork(com.tranphucvinh.jpa.model.Work work) {
		saveWork(work);
	}
}
 