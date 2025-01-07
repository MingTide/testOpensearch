package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * srp_out_elec_record_emergency_record
 * 电子病历-门急诊病历
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_out_elec_record_emergency_record")
public class SrpOutElecRecordEmergencyRecord extends RdBaseEntity {

    /**
     * 病案号
     */
    @TransField("病案号")
    private String patientId;


    /**
     * 就诊号（门诊号）
     */
    @TransField("就诊号（门诊号）")
    private String admissionId;

    /**
     * 就诊日期时间
     */
    @TransField("就诊日期时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date visitsTime;

    /**
     * 症状持续时间(min)
     */
    @TransField("症状持续时间(min)")
    private String symptomContinue;

    /**
     * 主诉
     */
    @TransField("主诉")
    private String outpatChiefCom;

    /**
     * 过敏史
     */
    @TransField("过敏史")
    private String outpatAllergies;

    /**
     * 现病史
     */
    @TransField("现病史")
    private String outpatPresentHis;

    /**
     * 既往史
     */
    @TransField("既往史")
    private String outpatPastHis;

    /**
     * 一般体格检查
     */
    @TransField("一般体格检查")
    private String outpatGeneral;

    /**
     * 辩证依据
     */
    @TransField("辩证依据")
    private String outpatTbopd;

    /**
     * 治疗原则(治则治法)
     */
    @TransField("治疗原则(治则治法)")
    private String outpatTreatmentPrincipal;
}