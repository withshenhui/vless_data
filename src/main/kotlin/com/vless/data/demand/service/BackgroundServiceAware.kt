package com.vless.data.demand.service

import com.vless.data.demand.model.Background
import com.vless.data.demand.query.BackgroundQuery
import com.vless.data.demand.result.PageResult

interface BackgroundServiceAware {

    fun save(background: Background) : Background

    fun deleteById(id:Long)

    fun findPage(backgroundQuery: BackgroundQuery) : PageResult

    fun findById(id:Long):Background

    fun findByBackgroundName(backgroundName:String):Background?
}