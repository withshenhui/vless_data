package com.vless.data.demand.mapper

import com.vless.data.demand.model.Background
import com.vless.data.demand.query.BackgroundQuery
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BackgroundMapper {

    fun selectAll(backgroundQuery: BackgroundQuery):List<Background>

    fun selectCount(backgroundQuery: BackgroundQuery):Int

}