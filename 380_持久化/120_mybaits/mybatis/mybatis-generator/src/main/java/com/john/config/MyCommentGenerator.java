package com.john.config;

import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 *	自定义注释生成demo
 *	
 */
@SuppressWarnings("unused")
public class MyCommentGenerator extends DefaultCommentGenerator{
	
	
	private boolean suppressAllComments;
	private boolean suppressDate;
    private boolean addRemarkComments;
    
    
    public void addConfigurationProperties(Properties properties) {
    	super.addConfigurationProperties(properties);
        suppressDate = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        suppressAllComments = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }
 
    
    /****TODO 实体类********************************************************/
    
    /**
     * 实体类的注释
     */
    public void addModelClassComment(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {

    	StringBuilder sb = new StringBuilder();

        topLevelClass.addJavaDocLine("/**"); //$NON-NLS-1$
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }
    
    /**
     * 实体类属性的注释
     */
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		field.addJavaDocLine(sb.toString());

		field.addJavaDocLine(" */");
	}

    /**
     * getter方法
     */
    public void addGetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
    }

    public void addSetterComment(Method method,
            IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
    }
    
    
    
    /****TODO SQL interface ********************************************************/   
    
    public void addGeneralMethodComment(Method method,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

//        StringBuilder sb = new StringBuilder();
//
//        method.addJavaDocLine("/**"); //$NON-NLS-1$
//        method
//                .addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$
//
//        sb.append(" * This method corresponds to the database table "); //$NON-NLS-1$
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        method.addJavaDocLine(sb.toString());
//
//        addJavadocTag(method, false);
//
//        method.addJavaDocLine(" */"); //$NON-NLS-1$
        
    }
    
    
    /****TODO SQL Mapper ********************************************************/
    
    public void addComment(XmlElement xmlElement) {
        if (suppressAllComments) {
            return;
        }

//        xmlElement.addElement(new TextElement("<!--")); //$NON-NLS-1$
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("  WARNING - "); //$NON-NLS-1$
//        sb.append(MergeConstants.NEW_ELEMENT_TAG);
//        xmlElement.addElement(new TextElement(sb.toString()));
//        xmlElement
//                .addElement(new TextElement(
//                        "  This element is automatically generated by MyBatis Generator, do not modify.")); //$NON-NLS-1$
//
//        String s = getDateString();
//        if (s != null) {
//            sb.setLength(0);
//            sb.append("  This element was generated on "); //$NON-NLS-1$
//            sb.append(s);
//            sb.append('.');
//            xmlElement.addElement(new TextElement(sb.toString()));
//        }
//
//        xmlElement.addElement(new TextElement("-->")); //$NON-NLS-1$
    
        }
}
