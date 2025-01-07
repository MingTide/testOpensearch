package com.medaxis.srp.search.search.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.medaxis.srp.rule.etl.model.*;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 反序列化对象
 * @author konglu
 * @date 2024/11/26
 */
@Data
public class SrpWideTableDeSerial {

    private String patientId;

    private List<SrpInHisPatient> srpInHisPatient;

    private List<SrpOutVisit> srpOutVisit;

    private List<SrpEcgInfo> srpEcgInfo;

    private List<SrpEchocardiogram> srpEchocardiogram;

    private List<SrpElecRecordAncillaryExamination> srpElecRecordAncillaryExamination;

    private List<SrpElecRecordDiagnosis> srpElecRecordDiagnosis;

    private List<SrpHisPatientDiagnosis> srpHisPatientDiagnosis;

    private List<SrpInElecRecordDischargeRecord> srpInElecRecordDischargeRecord;

    private List<SrpInElecRecordFirstDiseaseCourse> srpInElecRecordFirstDiseaseCourse;

    private List<SrpInElecRecordInpatients> srpInElecRecordInpatients;

    private List<SrpInImagingExamination> srpInImagingExamination;

    private List<SrpInMicrobialDrugSensitivity> srpInMicrobialDrugSensitivity;

    private List<SrpInOrders> srpInOrders;

    private List<SrpInPathologyReport> srpInPathologyReport;

    private List<SrpInRoutineInspection> srpInRoutineInspection;

    private List<SrpOutElecRecordEmergencyRecord> srpOutElecRecordEmergencyRecord;

    private List<SrpOutImagingExamination> srpOutImagingExamination;

    private List<SrpOutMicrobialDrugSensitivity> srpOutMicrobialDrugSensitivitie;

    private List<SrpOutOrders> srpOutOrders;

    private List<SrpOutPathologyReport> srpOutPathologyReport;

    private List<SrpOutRoutineInspection> srpOutRoutineInspection;

    private List<SrpOutHisPatient> srpOutHisPatient;

    private List<SrpOutElecRecordPrescription> srpOutElecRecordPrescription;

    private List<SrpDrugView> srpDrugView;

    private List<SrpInDiag> srpInDiag;

    private List<SrpInEmr> srpInEmr;
    private HashMap<String,String> filedTotalSize;

    /**
     * 住院时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date inTime;


    /**
     * 门诊时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date outTime;

    /**
     * 门诊号
     */
    private String admissionId;

    /**
     * 住院号
     */
    private String hosCaseNum;

    private  String highlight;
    private HashMap<String, Integer> totalSize;
}
