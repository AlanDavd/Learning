package com.company.bussinessRuleEngine;

@FunctionalInterface
interface Action{
    void execute(Facts facts);
}
