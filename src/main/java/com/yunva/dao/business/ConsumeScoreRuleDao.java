package com.yunva.dao.business;

import com.yunva.model.Page;
import com.yunva.model.business.ConsumeScoreRule;
import com.yunva.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 * <dl>
 * <dt>yunva-oneBuy-admin</dt>
 * <dd>Description: 消费积分规则 操作数据库层</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年3月3日</dd>
 * </dl>
 * @author 张志
 */

@Repository
public class ConsumeScoreRuleDao extends BaseRepository {


	public List<ConsumeScoreRule> getConsumeScoreRuleList(Page page)
	{
		return template.selectList("consumeScoreRule.rulelistPage",page);
	}

	public ConsumeScoreRule getConsumeScoreRuleById(Integer id) {
		return template.selectOne("consumeScoreRule.getConsumeScoreRuleById",id);
	}

	public void  updateConsumeScoreRule(ConsumeScoreRule info) {
		 template.update("consumeScoreRule.updateConsumeScoreRule", info);
	}

	public int saveConsumeScoreRule(ConsumeScoreRule info) {
		return template.insert("consumeScoreRule.saveConsumeScoreRule",info);
	}

	public void deleteConsumeScoreRule(Integer id ) {
		 template.delete("consumeScoreRule.deleteConsumeScoreRule", id);
	}
}
