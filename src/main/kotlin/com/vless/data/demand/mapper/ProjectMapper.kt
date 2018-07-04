package com.vless.data.demand.mapper

import com.vless.data.demand.model.Project
import com.vless.data.demand.query.ProjectQuery
import com.vless.data.demand.result.ProjectResult
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ProjectMapper {

    fun selectAll(projectQuery: ProjectQuery):List<ProjectResult>

    fun selectCount(projectQuery: ProjectQuery):Int

}