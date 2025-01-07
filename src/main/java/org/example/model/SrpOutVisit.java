package com.medaxis.srp.rule.etl.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.rule.vo.FieldVo;
import lombok.Data;
import java.util.Date;

/**
 * srp_out_visit
 * his-患者就诊信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@TableName("srp_out_visit")
public class SrpOutVisit extends FieldVo {

    /**
     * 病案号
     */
    @TransField("病案号")
    private String patientId;

    /**
     * 就诊号（门诊号）
     */
    @TransField("就诊号（门诊号）")
    private String admissionId;

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
     * 就诊路径(1.门诊；2.急诊)
     */
    @TransField("就诊路径")
    private String admissionType;

    /**
     * 入院属性(1.普通；2.绿色通道)
     */
    @TransField("入院属性")
    private String inHosProperty;

    /**
     * 发病日期时间
     */
    @TransField("发病日期时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date diseaseTime;

    /**
     * 到达本院急诊或者门诊日期时间
     */
    @TransField("到达本院急诊或者门诊日期时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date reachHosTime;

    /**
     * 急诊/门诊医师接诊日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TransField("急诊/门诊医师接诊日期")
    private Date firstAidTime;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TransField("创建时间")
    private Date createTime;
}