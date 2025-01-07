package com.medaxis.srp.rule.etl.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

/**
 * srp_elec_record_ancillary_examination
 * 电子病历-辅助检查
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_elec_record_ancillary_examination")
public class SrpElecRecordAncillaryExamination extends RdBaseEntity {

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
     * 就诊号（门诊号）
     */
    @TransField("就诊号（门诊号）")
    private String admissionId;

    /**
     * 辅助检查来源,1、入院记录；2、首次病程记录；3.日常病程记录；4.上级查房记录；5.疑难病例讨论；6.会诊记录；7.抢救记录；8.术前小结；9.术前讨论；10.术后首次病程记录；11.死亡记录；12.出院记录；13.出院小结；14.门（急）诊病历
     */
    @TransField("辅助检查来源")
    private String ancillarySource;

    /**
     * 辅助检查项目
     */
    @TransField("辅助检查项目")
    private String ancillaryProject;

    /**
     * 辅助检查结果
     */
    @TransField("辅助检查结果")
    private String ancillaryResult;
}