package com.vless.data.demand.mapper

import com.vless.data.demand.model.Demand
import com.vless.data.demand.query.DemandQuery
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DemandMapper {

    fun selectAll(demand: DemandQuery):List<Demand>

    fun selectCount(demand: DemandQuery):Int

}