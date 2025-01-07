package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * srp_in_imaging_examination
 * 住院患者影像学检查信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_in_imaging_examination")
public class SrpInImagingExamination extends RdBaseEntity {

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
     * 申请单号
     */
    @TransField("申请单号")
    private String requestNo;

    /**
     * 检查类型
     */
    @TransField("检查类型")
    private String radioType;

    /**
     * 检查项目
     */
    @TransField("检查项目")
    private String radioProject;

    /**
     * 检查方法
     */
    @TransField("检查方法")
    private String radioMethod;

    /**
     * 检查部位
     */
    @TransField("检查部位")
    private String radioPosition;

    /**
     * 检查时间
     */
    @TransField("检查时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date radioTime;

    /**
     * 检查结果
     */
    @TransField("检查结果")
    private String radioResult;

    /**
     * 检查提示（诊断）
     */
    @TransField("检查提示（诊断）")
    private String radioConclusion;

    /**
     * 检查具体数据(见心电图、超声心动图信息)
     */
    @TransField("检查具体数据")
    private String radioDate;

    /**
     * 报告时间
     */
    @TransField("报告时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date reportTime;
}