package org.example.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.example.MultiFormatDateDeserializer;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author konglu
 * @date 2022/9/8
 */
public class RdBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3472046269092947470L;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date createTime;

    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
     @JsonDeserialize(using = MultiFormatDateDeserializer.class)
private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
