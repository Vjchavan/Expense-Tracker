package com.project.expesetracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@DependsOn("calculateExpense")
public class BeanConfiguration {
}
