package org.example.model;

import com.baomidou.mybatisplus.annotation.TableName;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * srp_ecg_info
 * 心电图信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_ecg_info")
public class SrpEcgInfo extends RdBaseEntity {

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
     * 申请单号
     */
    @TransField("申请单号")
    private String requestNo;

    /**
     * 住院号
     */
    @TransField("住院号")
    private String hosCaseNum;

    /**
     * 心率
     */
    @TransField("心率")
    private String ecgHr;

    /**
     * P波
     */
    @TransField("P波")
    private String ecgP;

    /**
     * PR间期
     */
    @TransField("PR间期")
    private String ecgPr;

    /**
     * QT间期
     */
    @TransField("QT间期")
    private String ecgQt;

    /**
     * 心电轴
     */
    @TransField("心电轴")
    private String ecgAxis;

    /**
     * QRS波群
     */
    @TransField("QRS波群")
    private String ecgQrs;

    /**
     * ST段
     */
    @TransField("ST段")
    private String ecgSt;

    /**
     * T波
     */
    @TransField("T波")
    private String ecgT;

    /**
     * U波
     */
    @TransField("U波")
    private String ecgU;

    /**
     * 其他
     */
    @TransField("其他")
    private String ecgOther;

    /**
     * SV1
     */
    @TransField("SV1")
    private String ecgSv1;

    /**
     * RV5
     */
    @TransField("RV5")
    private String ecgRv5;

}