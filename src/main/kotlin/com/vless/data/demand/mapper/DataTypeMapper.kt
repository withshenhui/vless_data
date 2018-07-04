package com.vless.data.demand.mapper

import com.vless.data.demand.model.DataType
import com.vless.data.demand.query.DataTypeQuery
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DataTypeMapper {

    fun selectAll(dataTypeQuery: DataTypeQuery):List<DataType>

    fun selectCount(dataTypeQuery: DataTypeQuery):Int

}