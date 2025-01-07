package com.medaxis.srp.rule.etl.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * srp_out_routine_inspection
 * 门诊患者常规检验信息（生化、免疫、临检）
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("srp_out_routine_inspection")
public class SrpOutRoutineInspection extends RdBaseEntity {

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
     * 就诊号（门诊号）
     */
    @TransField("就诊号（门诊号）")
    private String admissionId;

    /**
     * 医嘱号
     */
    @TransField("医嘱号")
    private String hosOrderNum;

    /**
     * 申请单号
     */
    @TransField("申请单号")
    private String requestNo;

    /**
     * 样本号
     */
    @TransField("样本号")
    private String sampleNo;

    /**
     * 检验类型
     */
    @TransField("检验类型")
    private String labType;

    /**
     * 检验项目组合
     */
    @TransField("检验项目组合")
    private String labPortfolios;

    /**
     * 检验项目
     */
    @TransField("检验项目")
    private String labProject;

    /**
     * 检验标本
     */
    @TransField("检验标本")
    private String labPosition;

    /**
     * 检验定量结果
     */
    @TransField("检验定量结果")
    private String labResult;

    /**
     * 检验结果结论
     */
    @TransField("检验结果结论")
    private String labConclus;

    /**
     * 检验正常区间
     */
    @TransField("检验正常区间")
    private String labNor;

    /**
     * 单位
     */
    @TransField("单位")
    private String labUnit;

    /**
     * 标本采集时间
     */
    @TransField("标本采集时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date specimenTime;

    /**
     * 检验时间
     */
    @TransField("检验时间")
    private String labTime;

    /**
     * 报告时间
     */
    @TransField("报告时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date reportTime;
}