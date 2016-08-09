package com.yunva.model.business;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *
 * <dl>
 * <dt>yunva-oneBuy-admin</dt>
 * <dd>Description:消费送积分规则信息实体</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年5月11日</dd>
 * </dl>
 * @author 张志
 */
public class ConsumeScoreRule {

    private Integer id;  //主键id

    private Integer consumeMin; //消费最小区间值 以分为单位

    private Integer consumeMax; //消费区间最大值 以分为单位

    private Integer gainScore; //获取积分数


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; //创建时间



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsumeMin() {
        return consumeMin;
    }

    public void setConsumeMin(Integer consumeMin) {
        this.consumeMin = consumeMin;
    }

    public Integer getConsumeMax() {
        return consumeMax;
    }

    public void setConsumeMax(Integer consumeMax) {
        this.consumeMax = consumeMax;
    }

    public Integer getGainScore() {
        return gainScore;
    }

    public void setGainScore(Integer gainScore) {
        this.gainScore = gainScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConsumeScoreRule{");
        sb.append("id=").append(id);
        sb.append(", consumeMin=").append(consumeMin);
        sb.append(", consumeMax=").append(consumeMax);
        sb.append(", gainScore=").append(gainScore);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}