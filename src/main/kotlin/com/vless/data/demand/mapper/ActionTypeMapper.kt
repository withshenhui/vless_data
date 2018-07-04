package com.vless.data.demand.mapper

import com.vless.data.demand.model.ActionType
import com.vless.data.demand.query.ActionTypeQuery
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ActionTypeMapper {

    fun selectAll(actionTypeQuery: ActionTypeQuery):List<ActionType>

    fun selectCount(actionTypeQuery: ActionTypeQuery):Int

}