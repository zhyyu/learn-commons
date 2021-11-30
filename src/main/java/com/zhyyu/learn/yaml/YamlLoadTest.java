package com.zhyyu.learn.yaml;

import org.yaml.snakeyaml.Yaml;

public class YamlLoadTest {

    public static void main(String[] args) {
        Yaml yaml = new Yaml();

        // Use YAML to do data type conversion.
        Object replaceValue = yaml.load("12.12");
        System.out.println(replaceValue.getClass().getName());

        Object replaceValue2 = yaml.load("value");
        System.out.println(replaceValue2.getClass().getName());

//        Object value3 = yaml.load("!BI!2D");
//        System.out.println(value3.getClass().getName());

//        Object value4 = yaml.load("!BI32D");
//        System.out.println(value4.getClass().getName());


        Object value5 = yaml.load("animal: pets");
        System.out.println(value5);
        System.out.println(value5.getClass().getName());

        System.out.println("====================================================");
        Object value01 = yaml.load("str1");
        System.out.println(value01);
        System.out.println(value01.getClass().getName());

        Object value02 = yaml.load("true");
        System.out.println(value02);
        System.out.println(value02.getClass().getName());

        Object value03 = yaml.load("10");
        System.out.println(value03);
        System.out.println(value03.getClass().getName());

        Object value04 = yaml.load("3000000000");
        System.out.println(value04);
        System.out.println(value04.getClass().getName());
    }

}
