package com.yunva.service.impl;

import com.yunva.dao.business.ConsumeScoreRuleDao;
import com.yunva.model.Page;
import com.yunva.model.business.ConsumeScoreRule;
import com.yunva.service.ConsumeScoreRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeScoreRuleServiceImpl implements ConsumeScoreRuleService {


	@Autowired
	private ConsumeScoreRuleDao consumeScoreRuleRepository;

	@Override
	public List<ConsumeScoreRule> getConsumeScoreRuleList(Page page) {
		return consumeScoreRuleRepository.getConsumeScoreRuleList(page);
	}

	@Override
	public ConsumeScoreRule getConsumeScoreRuleById(Integer id) {
		return consumeScoreRuleRepository.getConsumeScoreRuleById(id);
	}

	@Override
	public void updateConsumeScoreRule(ConsumeScoreRule info) {

		consumeScoreRuleRepository.updateConsumeScoreRule(info);
	}

	@Override
	public int saveConsumeScoreRule(ConsumeScoreRule info) {
		return consumeScoreRuleRepository.saveConsumeScoreRule(info);
	}


	@Override
	public void deleteConsumeScoreRule(Integer id) {
		consumeScoreRuleRepository.deleteConsumeScoreRule(id);

	}
}
