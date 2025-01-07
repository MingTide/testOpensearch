package com.medaxis.srp.rule.etl.model;


import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * srp_in_his_patient
 * his-住院患者基本信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_in_his_patient")
public class SrpInHisPatient extends RdBaseEntity {

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
     * 住院医师
     */
    @TransField("住院医师")
    private String hosResident;

    /**
     * 主治医师
     */
    @TransField("主治医师")
    private String hosIndication;

    /**
     * 责任护士
     */
    @TransField("责任护士")
    private String hosResNurse;

    /**
     * 质控医师
     */
    @TransField("质控医师")
    private String hosControl;

    /**
     * 质控护士
     */
    @TransField("质控护士")
    private String hosControlNurse;

    /**
     * 质控日期
     */
    @TransField("质控日期")
    private Date hosControlTime;

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
    @TransField("患者出生日期")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    /**
     * 患者年龄
     */
    @TransField("患者年龄")
    private String age;

    /**
     * 患者年龄（月）
     */
    @TransField("患者年龄（月）")
    private String ageM;

    /**
     * 联系方式
     */
    @TransField("联系方式")
    private String telId;

    /**
     * 婚姻(1.未婚；2.已婚；3.丧偶；4.离婚；9.其他)
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
     * 身高
     */
    @TransField("身高")
    private String height;

    /**
     * 体重
     */
    @TransField("体重")
    private String weight;

    /**
     * 入院情况
     */
    @TransField("入院情况")
    private String inHosSituation;

    /**
     * 入院科室名称
     */
    @TransField("入院科室名称")
    private String inHosDepartName;

    /**
     * 入院科室编码（或者id）
     */
    @TransField("入院科室编码（或者id）")
    private String inHosDepartCode;

    /**
     * 出院科室名称
     */
    @TransField("出院科室名称")
    private String outHosDepartName;

    /**
     * 出院科室编码（或者id）
     */
    @TransField("出院科室编码（或者id）")
    private String outHosDepartCode;

    /**
     * 入院日期
     */
    @TransField("入院日期")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date inHosTime;

    /**
     * 出院日期
     */
    @TransField("出院日期")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date outHosTime;

    /**
     * 住院天数
     */
    @TransField("住院天数")
    private String hosDays;

    /**
     * 住院期间是否告病危或病重(1.无；2.有)
     *
     */
    @TransField("住院期间是否告病危或病重")
    private String hosCritical;

    /**
     * 药物过敏(1.无；2.有)
     */
    @TransField("药物过敏")
    private String hosDrugAllergy;

    /**
     * 是否因同一种病再入院(1.是、2.否)
     */
    @TransField("是否因同一种病再入院")
    private String hosSame;

    /**
     * 与上次出院时间间隔
     */
    @TransField("与上次出院时间间隔")
    private String hosLastTime;

    /**
     * 31天内再住院计划目的
     */
    @TransField("31天内再住院计划目的")
    private String hosRehosObj;

    /**
     * 入院途径(1门诊，；2急诊，；3其他医疗机构转入，；9其他)
     */
    @TransField("入院途径")
    private String inHosRoute;

    /**
     * 入院途径.其他医疗机构转入
     */
    @TransField("入院途径.其他医疗机构转入")
    private String inHosTransName;
    /**
     * 医疗付费方式(1.城镇职工基本医疗保险；2.城镇居民基本医疗保险；3.新型农村合作医疗；4.贫困救助；5.商业医疗保险；6.公费医疗；7.全自费；8.其他社会保险生育保险、工伤保险、农民工保险等；9.其他)
     */
    @TransField("医疗付费方式")
    private String hosMedicalPayMethod;

    /**
     * 离院方式(1.医嘱离院；2.医嘱转院；3.医嘱转社区卫生服务机构/乡镇卫生院；4.非医嘱离院、；5.死亡；9.其他)
     */
    @TransField("离院方式")
    private String hosOutWay;

    /**
     * 医嘱转院，拟接受医疗机构名称
     */
    @TransField("医嘱转院，拟接受医疗机构名称")
    private String hosInsName;

    /**
     * 医嘱转社区卫生服务机构/乡镇卫生院，拟接受医疗机构名称
     */
    @TransField("医嘱转社区卫生服务机构/乡镇卫生院，拟接受医疗机构名称")
    private String hosComName;

    /**
     * 转科情况(0.无转科； 1.有转科； 2.转院 ；3.未治自动出院； 4.自动出院 ；5.其他)
     */
    @TransField("转科情况")
    private String hosTransSitu;

    /**
     * RH血型(1.A；2.B；3.O；4.AB；5.不详；6.未查)
     */
    @TableField("hos_RH")
    @TransField("RH血型")
    private String hosRH;

    /**
     * 医疗组长姓名
     */
    private String teamName;

    /**
     * 医疗组长id
     */
    private String teamId;

    /**
     * 住院医生id
     */
    private String hosResidentId;

    /**
     * 住院标识
     */
    @TransField("住院标识")
    private String hosSign;
}