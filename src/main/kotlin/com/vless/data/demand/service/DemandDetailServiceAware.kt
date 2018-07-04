package com.vless.data.demand.service

import com.vless.data.demand.model.DemandDetail
import com.vless.data.demand.query.DemandDetailQuery
import com.vless.data.demand.result.DemandDetailActionResult
import com.vless.data.demand.result.DemandDetailResult
import com.vless.data.demand.result.PageResult

interface DemandDetailServiceAware {

    fun save(demandDetail:DemandDetail):DemandDetail

    fun deleteById(id:Long)

    fun findByDemandId(demandId:Long):List<DemandDetailResult>

    fun findActionByDemandIdAndBackgroundId(demandDetailQuery: DemandDetailQuery):List<DemandDetailActionResult>
}