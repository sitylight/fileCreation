package com.rabbitchop.config;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class NewbatisGenerator extends DefaultCommentGenerator {
    private Properties properties;
    private Properties systemPro;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;

    public NewbatisGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    /**
     * 对类的注解
     * @param topLevelClass
     * @param introspectedTable
     */
//    @Override
//    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        StringBuilder sb = new StringBuilder();
//        topLevelClass.addJavaDocLine("/**");
//        topLevelClass.addJavaDocLine(sb.toString());
//
//        String tableRemarks = introspectedTable.getRemarks();
//        if (!StringUtils.isEmpty(tableRemarks)) {
//            sb.setLength(0);
//            sb.append(" * 数据表注释 : ");
//            sb.append(tableRemarks);
//            topLevelClass.addJavaDocLine(sb.toString());
//        }
//
//        sb.setLength(0);
//        sb.append(" * @author ");
//        sb.append(systemPro.getProperty("user.name"));
//        topLevelClass.addJavaDocLine(sb.toString());
//
//        String curDateString = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
//        sb.setLength(0);
//        sb.append(" * @date ");
//        sb.append(curDateString);
//        topLevelClass.addJavaDocLine(sb.toString());
//
//        topLevelClass.addJavaDocLine(" */");
//        topLevelClass.setSuperClass("BaseMerchantEntity");
//        topLevelClass.addAnnotation("@Data");
//        topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = true)");
//        topLevelClass.addImportedType("lombok.Data");
//        topLevelClass.addImportedType("lombok.EqualsAndHashCode");
//        topLevelClass.addImportedType("com.example.demo.model.BaseMerchantEntity");
//        topLevelClass.addImportedType("javax.persistence.Column");
//    }

    /**
     * 生成的实体增加字段的中文注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
//        field.addAnnotation("@Column");

//        StringBuilder sb = new StringBuilder();
//        field.addJavaDocLine("/**");
//        sb.append(" * ");
//        sb.append(introspectedColumn.getRemarks());
//        field.addJavaDocLine(sb.toString().replace("\n", " "));
//        field.addJavaDocLine(" */");
    }
//
//    @Override
//    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
//            IntrospectedColumn introspectedColumn) {
//        super.addSetterComment(method, introspectedTable, introspectedColumn);
//    }
}
