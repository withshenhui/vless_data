package com.vless.data.demand.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name="v_project_action")
class ProjectAction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0

    @Column(name="project_id")
    @NotNull
    var projectId:Long? = null

    @Column(name="action_id")
    @NotNull
    var actionId:Long? = null


}