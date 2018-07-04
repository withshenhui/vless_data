package com.vless.data.demand.model

import com.vless.data.common.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name="v_demand_detail")
class DemandDetail{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0

    @Column(name="demand_id")
    @NotEmpty
    var demandId:Long? = null

    @Column(name="background_id")
    @NotEmpty
    var backgroundId:Long? = null

    @Column(name="action_id")
    @NotEmpty
    var actionId:Long? = null


}