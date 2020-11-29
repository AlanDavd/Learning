package com.company.bussinessRuleEngine;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
