package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * srp_elec_record_diagnosis
 * 电子病历-诊断信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_elec_record_diagnosis")
public class SrpElecRecordDiagnosis extends RdBaseEntity {

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
     * 就诊号（门诊号）
     */
    @TransField("就诊号（门诊号）")
    private String admissionId;

    /**
     * 诊断编码
     */
    @TransField("诊断编码")
    private String diagCode;

    /**
     * 诊断名称
     */
    @TransField("诊断名称")
    private String diagName;

    /**
     * 诊断次序
     */
    @TransField("诊断次序")
    private Integer diagSequence;

    /**
     * 诊断依据
     */
    @TransField("诊断依据")
    private String diagBasis;

    /**
     * 中医证候
     */
    @TransField("中医证候")
    private String chineseMedDiag;

    /**
     * 中医证候编码
     */
    @TransField("中医证候编码")
    private String chineseDiagCode;

    /**
     * 中医四诊观察结果
     */
    @TransField("中医四诊观察结果")
    private String chineseFourDiag;

    /**
     * 诊断类型
     */
    @TransField("诊断类型")
    private Integer diagType;

    /**
     * 诊断类型2
     */
    @TransField("诊断类型2")
    private String diagType2;

    /**
     * 诊断日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date diagTime;

    /**
     * 诊断来源
     */
    @TransField("诊断来源")
    private String diagSource;

    /**
     * 入院病情
     */
    @TransField("入院病情")
    private String inHosIllness;

    /**
     * 出院情况
     */
    @TransField("出院情况")
    private String outHosSituation;
}