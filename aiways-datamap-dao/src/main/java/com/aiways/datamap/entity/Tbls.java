package com.aiways.datamap.entity;

public class Tbls {
    private Long tblId;

    private Integer createTime;

    private Long dbId;

    private Integer lastAccessTime;

    private String owner;

    private Integer retention;

    private Long sdId;

    private String tblName;

    private String tblType;

    private String viewExpandedText;

    private String viewOriginalText;

    public Long getTblId() {
        return tblId;
    }

    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public Integer getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Integer lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public Integer getRetention() {
        return retention;
    }

    public void setRetention(Integer retention) {
        this.retention = retention;
    }

    public Long getSdId() {
        return sdId;
    }

    public void setSdId(Long sdId) {
        this.sdId = sdId;
    }

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName == null ? null : tblName.trim();
    }

    public String getTblType() {
        return tblType;
    }

    public void setTblType(String tblType) {
        this.tblType = tblType == null ? null : tblType.trim();
    }

    public String getViewExpandedText() {
        return viewExpandedText;
    }

    public void setViewExpandedText(String viewExpandedText) {
        this.viewExpandedText = viewExpandedText == null ? null : viewExpandedText.trim();
    }

    public String getViewOriginalText() {
        return viewOriginalText;
    }

    public void setViewOriginalText(String viewOriginalText) {
        this.viewOriginalText = viewOriginalText == null ? null : viewOriginalText.trim();
    }
}