package com.custom.demo.controller;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.custom.demo.common.pojo.RM;
import com.custom.demo.entity.ProjectSchedule;
import com.custom.demo.service.ProjectScheduleService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/projectschedule/")
public class ProjectScheduleController {

    @Autowired
    private ProjectScheduleService projectScheduleService;
    
    /**
     * 日期：2020年1月2日
     * 作者：zhb
     * 说明：查询所有计划
     * 
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("listAllPage")
    @ResponseBody
    public RM listAllPage(int page, int rows){
        try {
            PageInfo<ProjectSchedule> info = projectScheduleService.pageSelectAll(page, rows);
            return RM.success(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RM.fail();
    }
    
    /**
     * 日期：2020年1月2日
     * 作者：zhb
     * 说明：修改计划
     * 
     * @param ps
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public RM update(ProjectSchedule ps){
        try {
            int m = projectScheduleService.updateByPrimaryKeySelective(ps);
            if(m > 0){
                return RM.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RM.fail();
    }
    
    /**
     * 日期：2020年1月3日
     * 作者：zhb
     * 说明：查询计划
     * 
     * @param id
     * @return
     */
    @RequestMapping("selectOne")
    @ResponseBody
    public RM selectOne(int id){
        try {
            ProjectSchedule info = projectScheduleService.selectByPrimaryKey(id);
            return RM.success(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RM.fail();
    }
    
    /**
     * 日期：2020年1月3日
     * 作者：zhb
     * 说明：添加计划
     * 
     * @param projectSchedule
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public RM add(ProjectSchedule projectSchedule){
        try {
            String completeTime = projectSchedule.getCompleteTime();
            if(StringUtils.isBlank(completeTime))
                projectSchedule.setCompleteTime(null);
            int m = projectScheduleService.insertSelective(projectSchedule);
            if(m > 0){
                return RM.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RM.fail();
    }
    
    /**
     * 日期：2020年1月3日
     * 作者：zhb
     * 说明：删除计划
     * 
     * @param ids
     * @return
     */
    @RequestMapping("del")
    @ResponseBody
    public RM del(@RequestParam("ids[]")int[] ids){
        try {
            System.out.println("接收的数据: "+Arrays.asList(ids));
            int count = 0;
            int m = 0;
            for (int id : ids) {
                m = projectScheduleService.deleteByPrimaryKey(id);
                if(m < 1)
                    count++;
            }
            return RM.success(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RM.fail();
    }
    
    
}
