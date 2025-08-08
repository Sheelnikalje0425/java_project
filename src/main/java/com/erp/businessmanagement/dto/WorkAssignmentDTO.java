package com.erp.businessmanagement.dto;

import java.sql.Date;
import java.util.List;

public class WorkAssignmentDTO {

    private List<Integer> workerIds;
    private Integer orderId;
    private Date assignDate;
    private Integer fabricId;
    private Integer modelId;
    private Integer designId;
    private Date expectedCompletionDate;
    private String instruction;

    // --- Getters and Setters ---

    public List<Integer> getWorkerIds() {
        return workerIds;
    }

    public void setWorkerIds(List<Integer> workerIds) {
        this.workerIds = workerIds;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Integer getFabricId() {
        return fabricId;
    }

    public void setFabricId(Integer fabricId) {
        this.fabricId = fabricId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getDesignId() {
        return designId;
    }

    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    public Date getExpectedCompletionDate() {
        return expectedCompletionDate;
    }

    public void setExpectedCompletionDate(Date expectedCompletionDate) {
        this.expectedCompletionDate = expectedCompletionDate;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
