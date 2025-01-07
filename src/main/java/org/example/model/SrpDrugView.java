package com.medaxis.srp.rule.etl.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * srp_drug_view
 * @author medaxis
 * @date 2024-01-25 14:59:04
 */
@Data
@TableName("srp_drug_view")
public class SrpDrugView extends RdBaseEntity {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 病案号
     */
    private String patientId;

    /**
     * 主页id
     */
    private String homeId;

    /**
     * 住院号/门诊号
     */
    private String hosCaseNum;

    /**
     * 药物名称
     */
    private String drugName;

    /**
     * 药物剂型
     */
    private String medicineForm;

    /**
     * 药物规格
     */
    private String medicineSpeci;

    /**
     * 用药方式
     */
    private String drugMethod;

    /**
     * 开始时间
     */
    private Date drugStartTime;

    /**
     * 终止时间
     */
    private Date drugEndTime;

    /**
     * 药品分类1
     */
    private String drugType1;

    /**
     * 药品分类2
     */
    private String drugType2;

    /**
     * 药品分类3
     */
    private String drugType3;

    /**
     * 药品分类4
     */
    private String drugType4;

    /**
     * 医嘱期效（长期/临时）
     */
    private String docOrderAging;

    /**
     * 药物单位
     */
    private String medicineDoseUnit;

    /**
     * 药物剂量
     */
    private String drugDose;

    /**
     * 药物单次剂量
     */
    private String drugEachDose;

    /**
     * 药物频次
     */
    private String drugFrequency;

    /**
     * 药物来源（1.门/急诊；2.住院）
     */
    private String isEmeT;

    /**
     * 是否为出院带药（是/否）
     */
    private String outHosDrug;
}