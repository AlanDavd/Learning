package com.company.bussinessRuleEngine;

public interface ConditionalAction {
    void perform(Facts facts);
    boolean evaluate(Facts facts);
}
