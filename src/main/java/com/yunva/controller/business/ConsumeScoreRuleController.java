package com.yunva.controller.business;

import com.google.common.collect.Maps;
import com.yunva.controller.base.BaseController;
import com.yunva.model.Page;
import com.yunva.model.business.ConsumeScoreRule;
import com.yunva.service.ConsumeScoreRuleService;
import com.yunva.util.Const;
import com.yunva.util.PageData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <dl>
 * <dt>yunva-oneBuy-admin</dt>
 * <dd>Description:消费积分规则 controller层</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年1月6日</dd>
 * </dl>
 * @author 张志
 */

@Controller
@RequestMapping("/consumeScoreRule")
public class ConsumeScoreRuleController  extends BaseController {

	@Autowired
	private ConsumeScoreRuleService consumeScoreRuleService;




	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<ConsumeScoreRule> ruleList  = consumeScoreRuleService.getConsumeScoreRuleList(page);	//列出Pictures列表
		mv.setViewName("information/pictures/rule_list");
		mv.addObject("ruleList", ruleList);
		mv.addObject("pd", pd);
		mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		return mv;
	}



	/**
	 *添加页面
	 * @return
	 * @CreateDate: 2016年1月6日 上午10:54:20
	 * @author 张志
	 */
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mv = this.getModelAndView();
		HashMap<String, Object> model = Maps.newHashMap();
		ConsumeScoreRule info = new ConsumeScoreRule();
		mv.addObject("editType", "add");
		mv.addObject("saveMethod", "save");
		mv.setViewName("information/pictures/rule_add");
		model.put("info", info);
		return mv;
	}

	/**
	 *编辑页面
	 * @return
	 * @CreateDate: 2016年1月6日 上午10:54:20
	 * @author 张志
	 */
	@RequestMapping("edit")
	public ModelAndView edit(Integer id) {
		ModelAndView mv = this.getModelAndView();
		HashMap<String, Object> model = Maps.newHashMap();
		ConsumeScoreRule rule = consumeScoreRuleService.getConsumeScoreRuleById(id);
		mv.addObject("info", rule);
		mv.addObject("editType", "edit");
		mv.addObject("saveMethod", "modify");
		mv.setViewName("information/pictures/rule_edit");
		return mv;
	}


	/**
	 *保存消费积分规则信息
	 * @return
	 * @CreateDate: 2016年1月6日 上午10:54:20
	 * @author 张志
	 */
	@RequestMapping("save")
	public ModelAndView save(@ModelAttribute ConsumeScoreRule info)
	{
		ModelAndView mv = this.getModelAndView();
		consumeScoreRuleService.saveConsumeScoreRule(info);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}

	/**Nt
	 *修改红包数据
	 * @return
	 * @CreateDate: 2016年1月6日 上午10:54:20
	 * @author 张志
	 */
	@RequestMapping("modify")
	public ModelAndView modify(@ModelAttribute ConsumeScoreRule info)
	{
		ModelAndView mv = this.getModelAndView();
		consumeScoreRuleService.updateConsumeScoreRule(info);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}


	/**
	 *删除消费规则信息
	 * @return
	 * @CreateDate: 2016年1月6日 上午10:54:20
	 * @author 张志
	 */
	@RequestMapping("delete")
	public void delete(Integer id,PrintWriter out) {
		ModelAndView mv = this.getModelAndView();
		consumeScoreRuleService.deleteConsumeScoreRule(id);
		out.write("success");
		out.close();
	}


	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}

}