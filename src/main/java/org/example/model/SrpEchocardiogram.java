package com.medaxis.srp.rule.etl.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

/**
 * srp_echocardiogram
 * 超声心动图信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_echocardiogram")
public class SrpEchocardiogram extends RdBaseEntity {

    /**
     * 病案号
     */
    @TransField("病案号")
    private String patientId;

    /**
     * 申请单号
     */
    @TransField("申请单号")
    private String requestNo;

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
     * 主动脉窦部内径 (mm)
     */
    @TransField("主动脉窦部内径 (mm)")
    private String echoAsd;

    /**
     * 左心房前后径 (mm)
     */
    @TransField("左心房前后径 (mm)")
    private String echoLad;

    /**
     * 左心室舒张末期内径 (mm)
     */
    @TransField("左心室舒张末期内径 (mm)")
    private String echoLvdd;

    /**
     * LVEF( 二维 ,%)
     */
    @TransField("LVEF( 二维 ,%)")
    private String echoLvef;

    /**
     * 三尖瓣环收缩期位移(mm)
     */
    @TransField("三尖瓣环收缩期位移(mm)")
    private String echoTapse;

    /**
     * 右心室面积变化分数(%)
     */
    @TransField("右心室面积变化分数(%)")
    private String echoFac;

    /**
     * 近端升主动脉内径 (mm)
     */
    @TransField("近端升主动脉内径 (mm)")
    private String echoAaod;

    /**
     * 右心室舒张末期前后径 (mm)
     */
    @TransField("右心室舒张末期前后径 (mm)")
    private String echoRvvd;

    /**
     * 室间隔厚度 ( 舒张末期，mm)
     */
    @TransField("室间隔厚度 ( 舒张末期，mm)")
    private String echoIvst;

    /**
     * 左心室后壁厚度 ( 舒张末期，mm)
     */
    @TransField("左心室后壁厚度 ( 舒张末期，mm)")
    private String echoPlvw;

    /**
     * 左心房容积 (ml)
     */
    @TransField("左心房容积 (ml)")
    private String echoLvedv;

    /**
     * 二尖瓣 E(m/s)
     */
    @TransField("二尖瓣 E(m/s)")
    private String echoMve;

    /**
     * 二尖瓣反流速度 (m/s)
     */
    @TransField("二尖瓣反流速度 (m/s)")
    private String echoMvri;

    /**
     * 三尖瓣 E(m/s)
     */
    @TransField("三尖瓣 E(m/s)")
    private String echoTve;

    /**
     * 三尖瓣反流速度 (TRmax, m/s)
     */
    @TransField("三尖瓣反流速度 (TRmax, m/s)")
    private String echoTvri;

    /**
     * 主动脉瓣收缩期流速 (m/s)
     */
    @TransField("主动脉瓣收缩期流速 (m/s)")
    private String echoAvfl;

    /**
     * 肺动脉瓣收缩期流速 (m/s)
     */
    @TransField("肺动脉瓣收缩期流速 (m/s)")
    private String echoPvfl;

    /**
     * 二尖瓣环（间隔）S’(cm/s)
     */
    @TransField("二尖瓣环（间隔）S’(cm/s)")
    private String echoMbs1;

    /**
     * 二尖瓣环（间隔）A’(cm/s)
     */
    @TransField("二尖瓣环（间隔）A’(cm/s)")
    private String echoMba1;

    /**
     * 二尖瓣 A (m/s)
     */
    @TransField("二尖瓣 A (m/s)")
    private String echoMva;

    /**
     * 二尖瓣E/A
     */
    @TransField("二尖瓣E/A")
    private String echoMvea;

    /**
     * 三尖瓣 A (m/s)
     */
    @TransField("三尖瓣 A (m/s)")
    private String echoTva;

    /**
     * 三尖瓣E/A
     */
    @TransField("三尖瓣E/A")
    private String echoTvea;

    /**
     * 主动脉瓣反流速度 (m/s)
     */
    @TransField("主动脉瓣反流速度 (m/s)")
    private String echoAvri;

    /**
     * 肺动脉瓣反流速度（m/s)
     */
    @TransField("肺动脉瓣反流速度（m/s)")
    private String echoPvai;

    /**
     * 二尖瓣环（间隔）E’(cm/s)
     */
    @TransField("二尖瓣环（间隔）E’(cm/s)")
    private String echoMbe1;

    /**
     * 二尖瓣环（间隔）E’/A’
     */
    @TransField("二尖瓣环（间隔）E’/A’")
    private String echoMbea1;

    /**
     * 二尖瓣环（间隔）E/E’
     */
    @TransField("二尖瓣环（间隔）E/E’")
    private String echoMbee1;

    /**
     * 肺动脉收缩压 (mmHg)
     */
    @TransField("肺动脉收缩压 (mmHg)")
    private String echoSpap;

    /**
     * 右心房内径(mm)
     */
    @TransField("右心房内径(mm)")
    private String echoRa;

    /**
     * 左心室FS
     */
    @TransField("左心室FS")
    private String echoLvfs;

    /**
     * 左心室收缩末期内径(mm)
     */
    @TransField("左心室收缩末期内径(mm)")
    private String echoLvs;
}