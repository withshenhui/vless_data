package com.vless.data.demand.model

import com.vless.data.common.BaseEntity
import com.vless.data.demand.enum.ProjectStatusEnum
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name="v_project")
class Project : BaseEntity() {


    @Column(name="project_no")
    @NotEmpty
    var projectNo:String? = null

    @Column(name="project_name")
    @NotEmpty
    var projectName:String? = null

    @Column(name="project_owner_id")
    var projectOwnerId:Long? = null

    @Column(name="memo")
    var memo:String? = null


    @Column(name="status")
    @Enumerated(EnumType.STRING)
    @NotNull
    var status: ProjectStatusEnum? = null
}