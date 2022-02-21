package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
public class IfTagHandler extends TagSupport{
    public boolean condition;
    public IfTagHandler(){
        reset();
    }
    public void setCondition(boolean condition){
        this.condition = condition;
    }
    public boolean getCondition(){
        return this.condition;
    }
    public void reset(){
        this.condition = false;
    }
    public int doStartTag(){
        if(condition) return super.EVAL_BODY_INCLUDE;
        return super.SKIP_BODY;
    }
    public int doEndTag(){
        this.reset();
        return super.EVAL_PAGE;
    }
}