package org.example.model;

import com.alibaba.fastjson2.PropertyNamingStrategy;
import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.annotation.JSONType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * @author ：hu
 * @date ：Created in 2023/11/9 19:49
 * @description：  大宽表
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("srp_wide_table")
@JSONType(naming = PropertyNamingStrategy.SnakeCase)
public class SrpWideTable {

    /**
     * 病案号
     */
    private String patientId;

    /**
     * his-患者就诊信息
     */
    private String srpOutVisit;

    /**
     * 住院患者影像学检查信息
     */
    private String srpInImagingExamination;

    /**
     * 住院患者常规检验信息（生化、免疫、临检）
     */
    private String srpInRoutineInspection;

    /**
     * 住院患者微生物药敏信息
     */
    private String srpInMicrobialDrugSensitivity;

    /**
     * 住院患者病理报告信息
     */
    private String srpInPathologyReport;

    /**
     * 门诊患者常规检验信息（生化、免疫、临检）
     */
    private String srpOutRoutineInspection;

    /**
     * 门诊患者微生物药敏信息
     */
    private String srpOutMicrobialDrugSensitivity;

    /**
     * 门诊患者病理报告信息
     */
    private String srpOutPathologyReport;

    /**
     * 门诊患者影像学检查信息
     */
    private String srpOutImagingExamination;

    /**
     * 电子病历-诊断信息
     */
    private String srpElecRecordDiagnosis;

    /**
     * 电子病历-入院记录
     */
    private String srpInElecRecordInpatients;

    /**
     * 电子病历-首次病程记录
     */
    private String srpInElecRecordFirstDiseaseCourse;

    /**
     * 电子病历-出院记录
     */
    private String srpInElecRecordDischargeRecord;

    /**
     * 电子病历-辅助检查
     */
    private String srpElecRecordAncillaryExamination;

    /**
     * 电子病历-门急诊病历
     */
    private String srpOutElecRecordEmergencyRecord;

    /**
     * 门诊患者医嘱信息
     */
    private String srpOutOrders;

    /**
     * 住院患者医嘱信息
     */
    private String srpInOrders;

    /**
     * his-住院患者基本信息
     */
    private String srpInHisPatient;

    /**
     * his-住院患者诊断信息
     */
    private String srpHisPatientDiagnosis;

    /**
     * 超声心动图信息
     */
    private String srpEchocardiogram;

    /**
     * 心电图信息
     */
    private String srpEcgInfo;

    /**
     * his-门诊患者信息
     */
    private String srpOutHisPatient;

    /**
     * 住院诊断
     */
    private String srpInDiag;

    /**
     * 住院电子病历文书
     */
    private String srpInEmr;

    /**
     * 住院时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date inTime;


    /**
     * 门诊时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date outTime;

    /**
     * 门诊号
     */
    private String admissionId;

    /**
     * 住院号
     */
    private String hosCaseNum;
}










