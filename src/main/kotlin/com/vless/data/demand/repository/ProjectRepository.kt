package com.vless.data.demand.repository

import com.vless.data.demand.model.Project
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository:CrudRepository<Project,Long> {

    fun findByProjectName(projectName:String):Project?

}