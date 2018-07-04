package com.vless.data.demand.service

import com.vless.data.demand.model.Demand
import com.vless.data.demand.query.DemandQuery
import com.vless.data.demand.result.PageResult

interface DemandServiceAware {

    fun save(demand:Demand):Demand

    fun deleteById(id:Long)

    fun findPage(demand:DemandQuery):PageResult

    fun findById(id:Long):Demand
}