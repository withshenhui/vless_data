package com.vless.data.demand.mapper

import com.vless.data.demand.query.DemandQuery
import com.vless.data.demand.result.DemandResult
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DemandMapper {

    fun selectAll(demand: DemandQuery):List<DemandResult>

    fun selectCount(demand: DemandQuery):Int

}