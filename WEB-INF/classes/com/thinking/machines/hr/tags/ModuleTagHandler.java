package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
public class ModuleTagHandler extends TagSupport{
    public String name;
    public ModuleTagHandler(){
        reset();
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void reset(){
        this.name = "";
    }
    public int doStartTag(){
        pageContext.setAttribute("HOME",0,PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("DESIGNATION",1,PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("EMPLOYEE",2,PageContext.REQUEST_SCOPE);
        if(this.name.equalsIgnoreCase("HOME")){
            pageContext.setAttribute("module",0,PageContext.REQUEST_SCOPE);
        }else if(this.name.equalsIgnoreCase("DESIGNATION")){
            pageContext.setAttribute("module",1,PageContext.REQUEST_SCOPE);
        }else if(this.name.equalsIgnoreCase("EMPLOYEE")){
            pageContext.setAttribute("module",2,PageContext.REQUEST_SCOPE);
        }
        return super.SKIP_BODY;
    }
    public int doEndTag(){
        this.reset();
        return super.EVAL_PAGE;
    }
}
