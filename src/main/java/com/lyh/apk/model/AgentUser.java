package com.lyh.apk.model;

import java.io.Serializable;
import java.util.Date;

public class AgentUser implements Serializable{
    private Integer id;

    private Integer sysUserId;

    private Integer parentId;

    private Integer gameUserId;

    private String status;

    private Integer level;

    private Integer creater;

    private Date createTime;

    private String flag;

    private String remarks;

    private Integer divideRatio;//返点比例

    private String domainName;// 代理推广域名

    /**税收分成上限**/
    private Long taxRevenueMax;

    /**盈利分成上限**/
    private Long gainMax;

    /**混合分成税收分成比例上限**/
    private Long blendTaxRevenueMax;

    /**混合分成税收分成比例上限**/
    private Long blendGainMax;

    /** 分成类型 关联分成模式表id **/
    private Long divideIntoType;

    /** 姓名 **/
    private String realName;

    /** 银行卡号 **/
    private String bankNo;

    /**   开户行 **/
    private String cardHouseRow;

    /** 支行信息 **/
    private String branchInformation;

    /**联系电话**/
    private String mobile;

    /** 主要给代理用审核状态 0 未审核  1 发起审核  2 审核通过 **/
    private Integer auditingStatus;

    /**是否已生成新包**/
    private Integer createPackageFlag;

    public Long getTaxRevenueMax() {
        return taxRevenueMax;
    }

    public void setTaxRevenueMax(Long taxRevenueMax) {
        this.taxRevenueMax = taxRevenueMax;
    }

    public Long getGainMax() {
        return gainMax;
    }

    public void setGainMax(Long gainMax) {
        this.gainMax = gainMax;
    }

    public Long getBlendTaxRevenueMax() {
        return blendTaxRevenueMax;
    }

    public void setBlendTaxRevenueMax(Long blendTaxRevenueMax) {
        this.blendTaxRevenueMax = blendTaxRevenueMax;
    }

    public Long getBlendGainMax() {
        return blendGainMax;
    }

    public void setBlendGainMax(Long blendGainMax) {
        this.blendGainMax = blendGainMax;
    }

    public Long getDivideIntoType() {
        return divideIntoType;
    }

    public void setDivideIntoType(Long divideIntoType) {
        this.divideIntoType = divideIntoType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getCardHouseRow() {
        return cardHouseRow;
    }

    public void setCardHouseRow(String cardHouseRow) {
        this.cardHouseRow = cardHouseRow;
    }

    public String getBranchInformation() {
        return branchInformation;
    }

    public void setBranchInformation(String branchInformation) {
        this.branchInformation = branchInformation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAuditingStatus() {
        return auditingStatus;
    }

    public void setAuditingStatus(Integer auditingStatus) {
        this.auditingStatus = auditingStatus;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getGameUserId() {
        return gameUserId;
    }

    public void setGameUserId(Integer gameUserId) {
        this.gameUserId = gameUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getDivideRatio() {
        return divideRatio;
    }

    public void setDivideRatio(Integer divideRatio) {
        this.divideRatio = divideRatio;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }



    public Integer getCreatePackageFlag() {
        return createPackageFlag;
    }

    public void setCreatePackageFlag(Integer createPackageFlag) {
        this.createPackageFlag = createPackageFlag;
    }
}