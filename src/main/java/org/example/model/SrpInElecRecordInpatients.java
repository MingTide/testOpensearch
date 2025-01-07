package com.medaxis.srp.rule.etl.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

/**
 * srp_in_elec_record_inpatients
 * 电子病历-入院记录
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_in_elec_record_inpatients")
public class SrpInElecRecordInpatients extends RdBaseEntity {

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
     * 现病史
     */
    @TransField("现病史")
    private String hosPresentHis;

    /**
     * 一般健康状况
     */
    @TransField("一般健康状况")
    private String hosGeneralHea;

    /**
     * 患者传染病
     */
    @TransField("患者传染病")
    private String hosInfection;

    /**
     * 婚育史
     */
    @TransField("婚育史")
    private String hosObHis;

    /**
     * 过敏史
     */
    @TransField("过敏史")
    private String hosAllergies;

    /**
     * 手术史
     */
    @TransField("手术史")
    private String hosSurgery;

    /**
     * 预防接种史
     */
    @TransField("预防接种史")
    private String hosVaccination;

    /**
     * 输血史
     */
    @TransField("输血史")
    private String hosBlood;

    /**
     * 个人史
     */
    @TransField("个人史")
    private String hosHabits;

    /**
     * 月经史
     */
    @TransField("月经史")
    private String hosMenstruation;

    /**
     * 家族史
     */
    @TransField("家族史")
    private String hosFamilyHis;

    /**
     * 体温
     */
    @TransField("体温")
    private String hosT;

    /**
     * 脉率
     */
    @TransField("脉率")
    private String hosP;

    /**
     * 呼吸频率
     */
    @TransField("呼吸频率")
    private String hosR;

    /**
     * 收缩压
     */
    @TransField("收缩压")
    private String hosSp;

    /**
     * 舒张压
     */
    @TransField("舒张压")
    private String hosDp;

    /**
     * 身高
     */
    @TransField("身高")
    private String hosHeight;

    /**
     * 体重
     */
    @TransField("体重")
    private String hosWeight;

    /**
     * 一般状况检查
     */
    @TransField("一般状况检查")
    private String hosGeneral;

    /**
     * 皮肤和粘膜检查
     */
    @TransField("皮肤和粘膜检查")
    private String hosSkin;

    /**
     * 全身浅表淋巴结检查
     */
    @TransField("全身浅表淋巴结检查")
    private String hosNode;

    /**
     * 头部及其器官检查
     */
    @TransField("头部及其器官检查")
    private String hosHead;

    /**
     * 颈部检查
     */
    @TransField("颈部检查")
    private String hosNeck;

    /**
     * 胸部检查
     */
    @TransField("胸部检查")
    private String hosChest;

    /**
     * 腹部检查
     */
    @TransField("腹部检查")
    private String hosAbdomen;

    /**
     * 肛门检查
     */
    @TransField("肛门检查")
    private String hosAnus;

    /**
     * 外生殖器检查
     */
    @TransField("外生殖器检查")
    private String hosGenitalia;

    /**
     * 脊柱检查
     */
    @TransField("脊柱检查")
    private String hosSpine;

    /**
     * 四肢检查
     */
    @TransField("四肢检查")
    private String hosExtremities;

    /**
     * 神经系统检查
     */
    @TransField("神经系统检查")
    private String hosNerves;

    /**
     * 专科检查
     */
    @TransField("专科检查")
    private String hosSpecialPe;

    /**
     * 治疗计划
     */
    @TransField("治疗计划")
    private String hosTreatmentPlan;

    /**
     * 治疗原则(治则治法)
     */
    @TransField("治疗原则(治则治法)")
    private String hosTreatmentPrincipal;

    /**
     * 病例名称
     */
    @TransField("病例名称")
    private String caseName;
}