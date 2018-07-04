package com.vless.data.demand.form

import com.fasterxml.jackson.annotation.JsonFormat
import com.vless.data.demand.enum.ProjectStatusEnum
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty

class ProjectForm {

    @NotEmpty
    var projectNo:String? = null

    @NotEmpty
    var projectName:String? = null

    var projectOwnerId:Long? = null

    var memo:String? = null

    var id:Long = 0

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtCreate: Date = Date()

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtModified: Date? = null

    @Enumerated(EnumType.STRING)
    var status: ProjectStatusEnum? = null

    var actionList:LongArray=longArrayOf()
}