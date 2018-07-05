package com.vless.data.demand.model

import com.vless.data.common.BaseEntity
import com.vless.data.demand.enum.DemandStatusEnum
import com.vless.data.demand.query.DemandDetailQuery
import com.vless.data.demand.result.DemandDetailResult
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.service.DemandDetailServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name="v_demand")
class Demand : BaseEntity() {

    @Column(name="project_id")
    @NotEmpty
    var projectId:Long? = null

    @Column(name="data_type_id")
    @NotEmpty
    var dataTypeId:Long? = null

    @Column(name="demand_name")
    var demandName:String = ""

    @Column(name="amount")
    @NotEmpty
    var amount:Int? = null

    @Column(name="description")
    @NotEmpty
    var description = ""

    @Column(name="memo")
    var memo:String? = null

    @Column(name="needTag")
    @NotEmpty
    var needTag:Boolean=false

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var startDate:Date=Date()

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var endDate:Date? = null


    @Column(name="status")
    @Enumerated(EnumType.STRING)
    @NotEmpty
    var status:DemandStatusEnum? = null

    @Column(name = "create_user_id")
    @NotEmpty
    var createUserId:Long? = null
}