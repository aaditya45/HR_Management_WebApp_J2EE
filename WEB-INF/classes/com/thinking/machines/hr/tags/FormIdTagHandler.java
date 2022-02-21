package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import javax.servlet.jsp.*;
import java.io.*;

public class FormIdTagHandler extends TagSupport{
    public FormIdTagHandler(){
        reset();
    }
    public void reset(){
        //nothing to do
    }
    public int doStartTag(){
        String formID = UUID.randomUUID().toString();
        pageContext.setAttribute(formID,formID,PageContext.SESSION_SCOPE);
        JspWriter writer = pageContext.getOut();
        try {
            writer.print("<input type='hidden' name='formID' id='formID' value='"+formID+"'>");
        } catch (IOException e) {
            //do nothing
        }
        return SKIP_BODY;
    }
    public int doEndTag(){
        this.reset();
        return super.EVAL_PAGE;
    }
}