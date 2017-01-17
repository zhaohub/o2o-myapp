package com.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * Created by zhaogang3 on 2016/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml"})
public class SpringJunit {

    @Test
    public void test() {

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");

        EvaluationContext context = new StandardEvaluationContext();

        context.setVariable("end","!");
        Object value = expression.getValue(String.class);
        System.out.println(value);
    }
}
