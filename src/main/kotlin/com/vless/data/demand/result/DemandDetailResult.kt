package com.vless.data.demand.result

import com.vless.data.demand.query.DemandDetailQuery
import com.vless.data.demand.service.DemandDetailServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DemandDetailResult {

    var id:Long = 0

    var demandId:Long = 0

    var backgroundId:Long = 0

    var label:String = ""

    val children:List<DemandDetailActionResult>
        get() {
            var demandDetailQuery=DemandDetailQuery()
            demandDetailQuery.demandId=demandId
            demandDetailQuery.backgroundId=backgroundId
            return demandDetailService!!.findActionByDemandIdAndBackgroundId(demandDetailQuery)
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