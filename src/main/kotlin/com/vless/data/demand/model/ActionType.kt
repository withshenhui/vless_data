package com.vless.data.demand.model

import com.vless.data.common.BaseEntity
import com.vless.data.demand.enum.ProjectStatusEnum
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name="v_action_type")
class ActionType : BaseEntity() {


    @Column(name="action_name")
    @NotEmpty
    var actionName:String? = null


    @Column(name="memo")
    var memo:String? = null


    @Column(name="status")
    @Enumerated(EnumType.STRING)
    @NotNull
    var status:ProjectStatusEnum? = null

}