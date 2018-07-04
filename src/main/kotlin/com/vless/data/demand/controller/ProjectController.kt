package com.vless.data.demand.controller

import com.vless.data.common.BizException
import com.vless.data.demand.form.ProjectForm
import com.vless.data.demand.model.Action
import com.vless.data.demand.model.Project
import com.vless.data.demand.query.ActionQuery
import com.vless.data.demand.query.ProjectQuery
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.service.ActionServiceAware
import com.vless.data.demand.service.ProjectServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/project")
class ProjectController {

    @Autowired
    lateinit var projectService: ProjectServiceAware

    @PostMapping("/save")
    fun save(@RequestBody @Valid project: ProjectForm, result:BindingResult){
        project.gmtCreate= Date()
        project.projectOwnerId=1
        return if(result.hasErrors())
            throw BizException("提交信息有误")
        else if(projectService.findByProjectName(project.projectName!!)!=null)
            throw BizException("该项目名称已经存在")
        else
            projectService.save(project)
    }


    @PostMapping("/update")
    fun update(@RequestBody  @Valid project: ProjectForm, result: BindingResult){
        project.gmtModified=Date()
        return if(result.hasErrors())
            throw BizException("提交信息有误")
        else if(projectService.findByProjectName(project.projectName!!)!=null&&projectService.findByProjectName(project.projectName!!)!!.id!=project.id)
            throw BizException("该项目名称已经存在")
        else
            projectService.update(project)
    }


    @RequestMapping("/remove/{id}",method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id:Long) = projectService.deleteById(id)


    @GetMapping("/list")
    fun findPage(projectQuery: ProjectQuery):PageResult = projectService.findPage(projectQuery)

}