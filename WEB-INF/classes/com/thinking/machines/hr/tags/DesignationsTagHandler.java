package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
//body tag support helps to run body more than once.
public class DesignationsTagHandler extends BodyTagSupport{
    private List<DesignationBean> designations;
    private int index;
    public DesignationsTagHandler(){
        reset();
    }
    public void reset(){
        if(designations!=null){
            designations.clear();
            designations=null;
        }
    }
    public int doStartTag(){
        List<DesignationDTO> dlDesignations = null;
        try {
            dlDesignations = (new DesignationDAO()).getAll();
        } catch (DAOException e) {
            System.out.println(e.getMessage());
            return super.SKIP_BODY;
        }
        if (dlDesignations.size() == 0) {
            System.out.println("44");
            return super.SKIP_BODY;
        }
        designations = new ArrayList<>();
        DesignationBean designationBean;
        for(DesignationDTO designation : dlDesignations){
            designationBean = new DesignationBean();
            designationBean.setTitle(designation.getTitle());
            designationBean.setCode(designation.getCode());
            designations.add(designationBean);
        }
        index = 0;
        designationBean = designations.get(index);
        pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("serialNumber",index+1);
        return super.EVAL_BODY_INCLUDE;
    }
    public int doAfterBody(){
        index++;
        if(index == designations.size()){
            return super.SKIP_BODY;
        }
        DesignationBean designationBean;
        designationBean = designations.get(index);
        pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("serialNumber",index+1);
        return super.EVAL_BODY_AGAIN;
    }
    public int doEndTag(){
        this.reset();
        return super.EVAL_PAGE;
    }
}