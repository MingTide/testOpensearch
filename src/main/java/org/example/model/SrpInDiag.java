package com.medaxis.srp.rule.etl.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("srp_in_diag")
public class SrpInDiag extends RdBaseEntity {

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
     * 诊断类型
     */
    @TransField("诊断类型")
    private Integer diagType;

    /**
     * 诊断日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date diagTime;

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
