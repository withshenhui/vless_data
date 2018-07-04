package com.vless.data.demand.result

import com.fasterxml.jackson.annotation.JsonFormat
import com.vless.data.demand.enum.ProjectStatusEnum
import com.vless.data.demand.service.DemandDetailServiceAware
import com.vless.data.demand.service.ProjectServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Component
class ProjectResult {

    var id:Long = 0

    var projectName:String = ""

    var projectNo:String? = null

    var projectOwnerId:Long? = null

    var memo:String? = null

    @Enumerated(EnumType.STRING)
    var status: ProjectStatusEnum? = null

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtCreate: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtModified: Date? = null

    val actionList:List<ActionResult>
        get() {
            return projectService!!.findActionListByProjectId(id)
        }

    constructor()

    @Autowired
    constructor(projectService: ProjectServiceAware){
        Companion.projectService=projectService
    }

    companion object {
        var projectService: ProjectServiceAware? = null
    }
}