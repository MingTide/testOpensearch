package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * @author ：hu
 * @date ：Created in 2023/11/20 10:06
 * @description：his-门诊患者基础信息
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_out_his_patient")
public class SrpOutHisPatient extends RdBaseEntity {

    @TransField("病人id")
    private String patientId;

    @TransField("就诊号（门诊号）")
    private String admissionId;

    /**
     * 接诊医师
     */
    @TransField("接诊医师")
    private String hosResident;

    /**
     * 患者姓名
     */
    @TransField("患者姓名")
    private String name;

    /**
     * 患者性别
     */
    @TransField("患者性别")
    private String sex;

    /**
     * 患者出生日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TransField("患者出生日期")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date birthday;

    /**
     * 患者年龄(年)
     */
    @TransField("患者年龄(年)")
    private String age;

    /**
     * 患者年龄(月)
     */
    @TransField("患者年龄(月)")
    private String ageM;

    /**
     * 联系方式
     */
    @TransField("联系方式")
    private String telId;

    /**
     * 婚姻
     */
    @TransField("婚姻")
    private String marrige;

    /**
     * 职业
     */
    @TransField("职业")
    private String profession;

    /**
     * 民族
     */
    @TransField("民族")
    private String ethnic;

    /**
     * 患者身份证号
     */
    @TransField("患者身份证号")
    private String idNumber;

    /**
     * 新生儿出生体重
     */
    @TransField("新生儿出生体重")
    private String newBornWeight;


    /**
     * 入院情况
     */
    @TransField("入院情况")
    private String inHosSituation;

    /**
     * 就诊科室名称
     */
    @TransField("就诊科室名称")
    private String inHosDepartName;

    /**
     * 就诊科室编码（或者id）
     */
    @TransField("就诊科室编码")
    private String inHosDepartCode;

    /**
     * 药物过敏
     */
    @TransField("药物过敏")
    private String hosDrugAllergy;

    /**
     * 就诊途径(1门诊；2急诊；)
     */
    @TransField("就诊途径")
    private String inHosRoute;

    /**
     * 医疗付费方式
     */
    @TransField("医疗付费方式")
    private String hosMedicalPayMethod;

    /**
     * RH血型(1.A；2.B；3.O；4.AB；5.不详；6.未查)
     */
    @TableField("hos_RH")
    @TransField("RH血型")
    private String hosRH;

    /**
     * 住院标识，0.在院；1.出院；2.病案已归档
     */
    @TransField("住院标识")
    private String hosSign;
}
