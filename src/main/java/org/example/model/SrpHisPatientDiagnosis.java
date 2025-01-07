package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * srp_his_patient_diagnosis
 * his-患者诊断信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_his_patient_diagnosis")
public class SrpHisPatientDiagnosis {

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
    private String diagSequence;

    /**
     * 诊断类型，1.西医门诊诊断;2.西医入院诊断;3.西医出院诊断;5.院内感染;6.病理诊断;7.损伤中毒码,8.术前诊断;9.术后诊断;10.并发症;11.中医门诊诊断;12.中医入院诊断;13.中医出院诊断;21.病原学诊断;22.影像学诊断；23.合并症；24.病因诊断；
     */
    @TransField("诊断类型")
    private String diagType;

    /**
     * 诊断类型2，1.初步诊断；2.鉴别诊断；3.修正诊断；4.确定诊断；5.补充诊断；
     */
    @TransField("诊断类型2")
    private String diagType2;

    /**
     * 诊断日期
     */
    @TransField("诊断日期")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date diagTime;

    /**
     * 1有，2临床未确定，3情况不明，4无
     */
    @TransField("入院病情")
    private String inHosIllness;

    /**
     * 1治愈、2好转、3未愈、4无效、5死亡、9其他
     */
    @TransField("出院情况")
    private String outHosSituation;
}