package com.yunva.service;


import com.yunva.model.Page;
import com.yunva.model.business.ConsumeScoreRule;

import java.util.List;

public interface ConsumeScoreRuleService {

	public List<ConsumeScoreRule> getConsumeScoreRuleList(Page page);

	public ConsumeScoreRule getConsumeScoreRuleById(Integer id);

	public void  updateConsumeScoreRule(ConsumeScoreRule info) ;

	public int saveConsumeScoreRule(ConsumeScoreRule info);

	public void deleteConsumeScoreRule(Integer id);

	}
