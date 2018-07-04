package com.vless.data.demand.service

import com.vless.data.demand.model.DataType
import com.vless.data.demand.model.Demand
import com.vless.data.demand.query.DataTypeQuery
import com.vless.data.demand.query.DemandQuery
import com.vless.data.demand.result.PageResult

interface DataTypeServiceAware {

    fun save(dataType: DataType):DataType

    fun deleteById(id:Long)

    fun findByDataName(dataName:String):DataType?

    fun findPage(dataTypeQuery: DataTypeQuery):PageResult
}