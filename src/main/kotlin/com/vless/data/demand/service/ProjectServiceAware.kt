package com.vless.data.demand.service

import com.vless.data.demand.form.ProjectForm
import com.vless.data.demand.model.Project
import com.vless.data.demand.query.ProjectQuery
import com.vless.data.demand.result.ActionResult
import com.vless.data.demand.result.PageResult

interface ProjectServiceAware {

    fun save(project:ProjectForm)

    fun update(project:ProjectForm)

    fun deleteById(id:Long)

    fun findPage(projectQuery: ProjectQuery):PageResult

    fun findByProjectName(projectName:String):Project?

    fun findActionListByProjectId(projectId:Long):List<ActionResult>
}