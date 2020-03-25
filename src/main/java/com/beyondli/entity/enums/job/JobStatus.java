package com.beyondli.entity.enums.job;


public enum JobStatus {

    STOP("停止"),
    START("开始");
    private String name;

    JobStatus(String name) {
        this.name = name;
    }
}
