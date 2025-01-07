package com.medaxis.srp.rule.etl.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * srp_in_pathology_report
 * 住院患者病理报告信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_in_pathology_report")
public class SrpInPathologyReport extends RdBaseEntity {

    /**
     * 病案号
     */
    @TransField("病案号")
    private String patientId;

    /**
     * 主页id
     */
    @TransField("主页id")
    private String homeId;

    /**
     * 住院号
     */
    @TransField("住院号")
    private String hosCaseNum;

    /**
     * 医嘱号
     */
    @TransField("医嘱号")
    private String hosOrderNum;

    /**
     * 病理申请单号
     */
    @TransField("病理申请单号")
    private String patId;

    /**
     * 标本号
     */
    @TransField("标本号")
    private String patSampleId;

    /**
     * 标本组织来源
     */
    @TransField("标本组织来源")
    private String patSampleOri;

    /**
     * 病理标本部位
     */
    @TransField("病理标本部位")
    private String patSamplePosition;

    /**
     * 病理所见
     */
    @TransField("病理所见")
    private String patFinding;

    /**
     * 病理诊断结果
     */
    @TransField("病理诊断结果")
    private String patDiagnosis;

    /**
     * 病理样本送检时间
     */
    @TransField("病理样本送检时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date patSampleTime;

    /**
     * 病理报告日期
     */
    @TransField("病理报告日期")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date patReportTime;
}