package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.example.MultiFormatDateDeserializer;

import java.util.Date;

/**
 * srp_in_orders
 * 住院患者医嘱信息
 * @author medaxis
 * @date 2023-11-08 15:33:09
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("srp_in_orders")
public class SrpInOrders extends RdBaseEntity {

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
     * 医嘱号
     */
    @TransField("医嘱号")
    private String medicalOrderNum;

    /**
     * 医嘱组号
     */
    @TransField("医嘱组号")
    private String medicalGroupNum;

    /**
     * 医嘱关联号
     */
    @TransField("医嘱关联号")
    private String orderAssociationNum;

    /**
     * 开医嘱医生名称
     */
    @TransField("开医嘱医生名称")
    private String orderDoctorName;

    /**
     * 开医嘱医生编码
     */
    @TransField("开医嘱医生编码")
    private String orderDoctorNum;

    /**
     * 医嘱状态(-1.未生效的暂存医嘱；1.新开；2.校对疑问；3.已校对；4.已作废；5.已重整；6.已暂停；7.已启用；8.已停止；9.已确认停止)
     */
    @TransField("医嘱状态")
    private String docOrderStatus;

    /**
     * 医嘱期效(0.临时；1.长期)
     */
    @TransField("医嘱期效")
    private String docOrderAging;

    /**
     * 医嘱项目分类
     */
    @TransField("医嘱项目分类")
    private String medicalCategory;

    /**
     * 医嘱项目分类id
     */
    @TransField("医嘱项目分类id")
    private String medicalCategoryId;

    /**
     * 诊疗类别
     */
    @TransField("诊疗类别")
    private String diagType;

    /**
     * 诊疗类别编码
     */
    @TransField("诊疗类别编码")
    private String diagTypeId;

    /**
     * 诊疗项目名称
     */
    @TransField("诊疗项目名称")
    private String diagEvent;

    /**
     * 诊疗项目id
     */
    @TransField("诊疗项目id")
    private String diagEventId;

    /**
     * 收费细目id
     */
    @TransField("收费细目id")
    private String feeBreakdownId;

    /**
     * 天数
     */
    @TransField("天数")
    private String day;

    /**
     * 医嘱内容
     */
    @TransField("医嘱内容")
    private String docOrderDetail;

    /**
     * 皮试结果(1.阴性；2.阳性)
     */
    @TransField("皮试结果")
    private String skinTestResult;

    /**
     * 开始执行时间
     */
    @TransField("开始执行时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date startTime;

    /**
     * 执行终止时间
     */
    @TransField("执行终止时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date endTime;

    /**
     * 上次执行时间
     */
    @TransField("上次执行时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date lastTime;

    /**
     * 下达科室
     */
    @TransField("下达科室")
    private String dachRoom;

    /**
     * 医嘱下达时间
     */
    @TransField("医嘱下达时间")
    private String medicalOrderTime;

    /**
     * 执行科室
     */
    @TransField("执行科室")
    private String executiveDepartment;

    /**
     * 药品名称
     */
    @TransField("药品名称")
    private String drugName;

    /**
     * 药物剂型
     */
    @TransField("药物剂型")
    private String medicineForm;

    /**
     * 药物规格
     */
    @TransField("药物规格")
    private String medicineSpeci;

    /**
     * 药物使用-频率(1.bid；2.qd；3.tid；4.qid；5.qod；6.q2h；7.q3h；8.q4h；9.q6h；10.q8h；11.q12h；12.qw；13.biw；14.tiw；15.qiw；16.q2w；17.q3w；18.q4w；19.一周四次以上；20.30分钟一次)
     */
    @TransField("药物使用-频率")
    private String medicineFreq;

    /**
     * 药物使用-总剂量
     */
    @TransField("药物使用-总剂量")
    private String medicineTotalDose;

    /**
     * 药物使用-次剂量
     */
    @TransField("药物使用-次剂量")
    private String medicineEachDose;

    /**
     * 药物使用-剂量单位
     */
    @TransField("药物使用-剂量单位")
    private String medicineDoseUnit;

    /**
     * 药物使用-途径
     */
    @TransField("药物使用-途径")
    private String medicineWay;

    /**
     * 用药开始时间
     */
    @TransField("用药开始时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date medicineStartTime;

    /**
     * 用药停止时间
     */
    @TransField("用药停止时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date medicineEndTime;

    /**
     * 用药天数
     */
    @TransField("用药天数")
    private String medicineApplicationDay;

    /**
     * 是否出院带药(是/否/自备)
     */
    @TransField("是否出院带药(是/否/自备)")
    private String dischargeMedicine;
}