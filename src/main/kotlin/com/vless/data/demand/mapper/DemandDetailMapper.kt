package com.vless.data.demand.mapper

import com.vless.data.demand.query.DemandDetailQuery
import com.vless.data.demand.result.DemandDetailActionResult
import com.vless.data.demand.result.DemandDetailResult
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DemandDetailMapper {

    fun selectBackgroundByDemandId(demandId: Long):List<DemandDetailResult>

    fun findActionByDemandIdAndBackgroundId(demandDetailQuery: DemandDetailQuery):List<DemandDetailActionResult>
}