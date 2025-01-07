package com.medaxis.srp.rule.etl.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.medaxis.srp.rule.domain.mdr.annotation.TransField;
import com.medaxis.srp.rule.domain.global.RdBaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("srp_in_elec_record_inpatients")
public class SrpInEmr extends RdBaseEntity {
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
     * 病历流水号
     */
    @TransField("病历流水号")
    private String emrId;

    /**
     * 病历类型
     */
    @TransField("病历类型")
    private String emrType;

    /**
     * 病历类型编码
     */
    @TransField("病历类型编码")
    private String emrTypeCode;

    /**
     * 病历名称
     */
    @TransField("病历名称")
    private String emrName;

    /**
     * 病历内容
     */
    @TransField("病历内容")
    private String emrContent;

    /**
     * 签名时间
     */
    @TransField("签名时间")
    private Date signTime;

    /**
     * 签名人
     */
    @TransField("签名人")
    private String signName;
}
