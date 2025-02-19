package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * srp_in_microbial_drug_sensitivity
 * 住院患者微生物药敏信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_in_microbial_drug_sensitivity")
public class SrpInMicrobialDrugSensitivity extends RdBaseEntity {

    /**
     * 病案号
     */
    @TransField("病案号")
    private String patientId;


    /**
     * 住院号
     */
    @TransField("住院号")
    private String hosCaseNum;

    /**
     * 主页id
     */
    @TransField("主页id")
    private String homeId;

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
    private String microType;

    /**
     * 检验项目组合
     */
    @TransField("检验项目组合")
    private String microPortfolios;

    /**
     * 检验项目
     */
    @TransField("检验项目")
    private String microProject;

    /**
     * 检验标本
     */
    @TransField("检验标本")
    private String microPosition;

    /**
     * 鉴定（培养）结果
     */
    @TransField("鉴定（培养）结果")
    private String microResult;

    /**
     * 目标细菌（药敏）
     */
    @TransField("目标细菌（药敏）")
    private String microBacteria;

    /**
     * 抗菌药物名称
     */
    @TransField("抗菌药物名称")
    private String microAnti;

    /**
     * MIC
     */
    @TransField("MIC")
    private String microMic;

    /**
     * 敏感度(耐药；中介；耐药)
     */
    @TransField("敏感度(耐药；中介；耐药)")
    private String microSensitivity;

    /**
     * 涂片结果描述
     */
    @TransField("涂片结果描述")
    private String microDescription;

    /**
     * 标本采集时间
     */
    @TransField("标本采集时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date specimenTime;

    /**
     * 检验时间
     */
    @TransField("检验时间")
    private String microTime;

    /**
     * 报告时间
     */
    @TransField("报告时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date reportTime;
}