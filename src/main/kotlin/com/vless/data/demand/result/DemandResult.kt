package com.vless.data.demand.result

import com.fasterxml.jackson.annotation.JsonFormat
import com.vless.data.demand.enum.DemandStatusEnum
import com.vless.data.demand.query.DemandDetailQuery
import com.vless.data.demand.service.DemandDetailServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.*

@Component
class DemandResult {

    var id:Long = 0

    var projectId:Long? = null

    var projectName:String = ""

    var demandName:String = ""

    var dataTypeId:Long? = null

    var dataTypeName:String = ""

    var amount:Int? = null

    var description = ""

    var memo:String? = null

    var needTag:Boolean=false

    @Temporal(TemporalType.DATE)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var startDate: Date = Date()

    @Temporal(TemporalType.DATE)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var endDate: Date? = null

    @Enumerated(EnumType.STRING)
    var status: DemandStatusEnum? = null

    var createUserId:Long? = null

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtCreate: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtModified: Date? = null

    val detailResult:List<DemandDetailResult>
        get() {
            return demandDetailService!!.findByDemandId(id)
        }

    constructor()

    @Autowired
    constructor(demandDetailService: DemandDetailServiceAware){
        Companion.demandDetailService=demandDetailService
    }

    companion object {
        var demandDetailService: DemandDetailServiceAware? = null
    }
}