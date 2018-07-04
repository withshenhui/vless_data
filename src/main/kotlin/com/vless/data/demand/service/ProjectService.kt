package com.vless.data.demand.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.vless.data.demand.enum.ProjectStatusEnum
import com.vless.data.demand.form.ProjectForm
import com.vless.data.demand.mapper.ProjectActionMapper
import com.vless.data.demand.mapper.ProjectMapper
import com.vless.data.demand.model.Project
import com.vless.data.demand.model.ProjectAction
import com.vless.data.demand.query.ProjectQuery
import com.vless.data.demand.repository.ProjectActionRepository
import com.vless.data.demand.repository.ProjectRepository
import com.vless.data.demand.result.ActionResult
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.result.ProjectResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProjectService : ProjectServiceAware {


    @Autowired
    lateinit var projectRepository:ProjectRepository

    @Autowired
    lateinit var projectActionRepository: ProjectActionRepository

    @Autowired
    lateinit var projectMapper: ProjectMapper

    @Autowired
    lateinit var projectActionMapper: ProjectActionMapper

    @Transactional
    override fun deleteById(id: Long) {
        projectRepository.deleteById(id)
        projectActionRepository.deleteByProjectId(id)
    }

    override fun findByProjectName(projectName: String): Project? = projectRepository.findByProjectName(projectName)

    @Transactional(readOnly = true)
    override fun findPage(projectQuery: ProjectQuery): PageResult {
        PageHelper.startPage<ProjectResult>(projectQuery.page,projectQuery.limit)
        val projectList:List<ProjectResult> = projectMapper.selectAll(projectQuery)
        val pageInfo: PageInfo<ProjectResult> = PageInfo(projectList)
        return PageResult(pageInfo.total,projectList)
    }

    @Transactional
    override fun save(projectForm: ProjectForm){
        var project:Project= Project()
        project.id=projectForm.id
        project.projectName=projectForm.projectName
        project.memo=projectForm.memo
        project.projectNo=projectForm.projectNo
        project.gmtModified=projectForm.gmtModified
        project.projectOwnerId=projectForm.projectOwnerId
        project.status= ProjectStatusEnum.CREATED
        val p=projectRepository.save(project)
        for(actionId:Long in projectForm.actionList){
            var projectAction:ProjectAction= ProjectAction()
            projectAction.actionId=actionId
            projectAction.projectId=p.id
            projectActionRepository.save(projectAction)
        }
    }

    @Transactional
    override fun update(projectForm: ProjectForm){
        var project:Project= Project()
        project.id=projectForm.id
        project.projectName=projectForm.projectName
        project.memo=projectForm.memo
        project.projectNo=projectForm.projectNo
        project.gmtModified=projectForm.gmtModified
        project.projectOwnerId=projectForm.projectOwnerId
        project.status=projectForm.status
        projectRepository.save(project)
        projectActionRepository.deleteByProjectId(projectForm.id)
        for(actionId:Long in projectForm.actionList){
            var projectAction:ProjectAction= ProjectAction()
            projectAction.actionId=actionId
            projectAction.projectId=projectForm.id
            projectActionRepository.save(projectAction)
        }
    }

    override fun findActionListByProjectId(projectId: Long): List<ActionResult> {
        return projectActionMapper.findActionListByProjectId(projectId)
    }
}