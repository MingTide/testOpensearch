package com.medaxis.srp.rule.etl.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

/**
 * srp_in_elec_record_first_disease_course
 * 电子病历-首次病程记录
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_in_elec_record_first_disease_course")
public class SrpInElecRecordFirstDiseaseCourse extends RdBaseEntity {

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
     * 主诉
     */
    @TransField("主诉")
    private String hosChiefCom;

    /**
     * 治疗计划
     */
    @TransField("治疗计划")
    private String hosTreatmentPlan;


    /**
     * 病例特点
     */
    @TransField("病例特点")
    private String hosPatCChara;

    /**
     * 治疗原则(治则治法)
     */
    @TransField("治疗原则(治则治法)")
    private String hosTreatmentPrincipal;
}