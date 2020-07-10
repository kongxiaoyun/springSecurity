package com.hy.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 设备告警信息表
 * </p>
 *
 * @author Terry
 * @since 2019-06-05
 */
public class TAlarmEquip implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 告警标识
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 设备标识
     */
    private String equipId;
    /**
     * 点位标识
     */
    private Long pointId;
    /**
     * 告警发生时间
     */
    private Date alarmTime;
    /**
     * 告警类型（1:设备，2：通道）
     */
    private Integer alarmType;
    /**
     * 告警值
     */
    private String alarmValue;
    /**
     * 告警等级（1：一般告警，2：严重告警）
     */
    private Integer alarmLv;
    /**
     * 告警状态（1：告警，2：恢复）
     */
    private Integer alarmStauts;
    /**
     * 是否已读(0:未读，1：已读)
     */
    private Integer isRead;
    /**
     * 告警确认(0：未确认 1：已确认)
     */
    private Integer alarmMaarker;
    /**
     * 告警描述
     */
    private String alarmDescribe;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(String alarmValue) {
        this.alarmValue = alarmValue;
    }

    public Integer getAlarmLv() {
        return alarmLv;
    }

    public void setAlarmLv(Integer alarmLv) {
        this.alarmLv = alarmLv;
    }

    public Integer getAlarmStauts() {
        return alarmStauts;
    }

    public void setAlarmStauts(Integer alarmStauts) {
        this.alarmStauts = alarmStauts;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getAlarmMaarker() {
        return alarmMaarker;
    }

    public void setAlarmMaarker(Integer alarmMaarker) {
        this.alarmMaarker = alarmMaarker;
    }

    public String getAlarmDescribe() {
        return alarmDescribe;
    }

    public void setAlarmDescribe(String alarmDescribe) {
        this.alarmDescribe = alarmDescribe;
    }

    @Override
    public String toString() {
        return "TAlarmEquip{" +
        ", id=" + id +
        ", equipId=" + equipId +
        ", pointId=" + pointId +
        ", alarmTime=" + alarmTime +
        ", alarmType=" + alarmType +
        ", alarmValue=" + alarmValue +
        ", alarmLv=" + alarmLv +
        ", alarmStauts=" + alarmStauts +
        ", isRead=" + isRead +
        ", alarmMaarker=" + alarmMaarker +
        ", alarmDescribe=" + alarmDescribe +
        "}";
    }
}
