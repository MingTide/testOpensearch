package com.medaxis.srp.rule.etl.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

/**
 * srp_in_elec_record_discharge_record
 * 电子病历-出院记录
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_in_elec_record_discharge_record")
public class SrpInElecRecordDischargeRecord extends RdBaseEntity {

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
     * 手术操作
     */
    @TransField("手术操作")
    private String surgeryDetails;

    /**
     * 中药煎煮方法
     */
    @TransField("中药煎煮方法")
    private String hosTcmDecoction;

    /**
     * 中药用药方法
     */
    @TransField("中药用药方法")
    private String hosTcmMothod;

    /**
     * 入院情况
     */
    @TransField("入院情况")
    private String inHosSituation;

    /**
     * 实际住院天数
     */
    @TransField("实际住院天数")
    private String hosDays;

    /**
     * 诊疗过程
     */
    @TransField("诊疗过程")
    private String treatmentDescribe;

    /**
     * 治疗结果
     */
    @TransField("治疗结果")
    private String treatmentResult;

    /**
     * 出院情况
     */
    @TransField("出院情况")
    private String outHosSituation;

    /**
     * 出院医嘱
     */
    @TransField("出院医嘱")
    private String outHosOrder;
}