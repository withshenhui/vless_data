package com.vless.data.demand.mapper

import com.vless.data.demand.model.Action
import com.vless.data.demand.query.ActionQuery
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ActionMapper {

    fun selectAll(actionQuery: ActionQuery):List<Action>

    fun selectCount(actionQuery: ActionQuery):Int



}