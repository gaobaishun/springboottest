package com.neo.entity;


public class Test {

    private Integer testId;
    private String testKey;
    private String testValue;

    public Integer getTestId() {
        return testId;
    }

    public String getTestKey() {
        return testKey;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public void setTestKey(String testKey) {
        this.testKey = testKey;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", testKey='" + testKey + '\'' +
                ", testValue='" + testValue + '\'' +
                '}';
    }
}
