package com.vless.data.demand.repository

import com.vless.data.demand.model.DataType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DataTypeRepository:CrudRepository<DataType,Long> {

    fun findByDataName(dataName:String):DataType?
}