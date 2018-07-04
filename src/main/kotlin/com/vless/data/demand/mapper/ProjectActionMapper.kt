package com.vless.data.demand.mapper

import com.vless.data.demand.result.ActionResult
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface ProjectActionMapper {

    @Select("select a.id,a.action_no,a.action_name,a.action_images FROM v_project_action pa" +
            " INNER JOIN v_action a ON a.id=pa.action_id WHERE pa.project_id=#{projectId}"
            )
    fun findActionListByProjectId(@Param("projectId") projectId: Long?): List<ActionResult>
}