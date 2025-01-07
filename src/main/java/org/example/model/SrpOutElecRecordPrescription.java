package org.example.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SrpOutElecRecordPrescription extends RdBaseEntity {

    /**
     * 病人id
     */
    @TransField("病人id")
    private String patientId;

    /**
     * 就诊号（门诊号）
     */
    @TransField("就诊号（门诊号）")
    private String admissionId;

    /**
     * 处方编号
     */
    @TransField("处方编号")
    private String rxNumber;

    /**
     * 处方开立日期时间
     */
    @TransField("处方开立日期时间")
 @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date rxTime;

    /**
     * 处方开立医师
     */
    @TransField("处方开立医师")
    private String rxDoctor;

    /**
     * 处方有效天数
     */
    @TransField("处方有效天数")
    private int rxDays;

    /**
     * 处方开立科室名称
     */
    @TransField("处方开立科室名称")
    private String rxDepartment;

    /**
     * 药物名称
     */
    @TransField("药物名称")
    private String medicineName;

    /**
     * 药物规格
     */
    @TransField("药物规格")
    private String medicineSpecification;

    /**
     * 药物剂型代码
     */
    @TransField("药物剂型代码")
    private String medicineFormCode;

    /**
     * 药物使用次剂量
     */
    @TransField("药物使用次剂量")
    private String medicineEachDose;

    /**
     * 药物使用剂量单位
     */
    @TransField("药物使用剂量单位")
    private String medicineDoseUnit;

    /**
     * 药物使用频率代码
     */
    @TransField("药物使用频率代码")
    private String medicineFreq;

    /**
     * 用药途径代码
     */
    @TransField("用药途径代码")
    private String medicineWay;

    /**
     * 药物使用总剂量
     */
    @TransField("药物使用总剂量")
    private String medicineTotalDose;

    /**
     * 处方药品组号
     */
    @TransField("处方药品组号")
    private String rxMedicineNumber;

    /**
     * 中药饮片处方
     */
    @TransField("中药饮片处方")
    private String rxChineseMed;

    /**
     * 中药饮片剂数（剂）
     */
    @TransField("中药饮片剂数（剂）")
    private String rxChineseDose;

    /**
     * 中药饮片煎煮法
     */
    @TransField("中药饮片煎煮法")
    private String rxChineseForm;

    /**
     * 中药用药方法
     */
    @TransField("中药用药方法")
    private String rxChineseMethod;

    /**
     * 治则治法
     */
    @TransField("治则治法")
    private String outpatTreatmentPrincipal;

    /**
     * 处方类别，1、西医；2.中医
     */
    @TransField("处方类别")
    private int rxType;
}
