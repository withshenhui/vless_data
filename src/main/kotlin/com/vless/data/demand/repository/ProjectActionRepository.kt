package com.vless.data.demand.repository

import com.vless.data.demand.model.ProjectAction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectActionRepository:CrudRepository<ProjectAction,Long> {

    fun deleteByProjectId(projectId:Long)
}