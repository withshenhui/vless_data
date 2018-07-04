package com.vless.data.demand.service

import com.vless.data.demand.model.ActionType
import com.vless.data.demand.query.ActionTypeQuery
import com.vless.data.demand.result.PageResult

interface ActionTypeServiceAware {

    fun save(actionType: ActionType):ActionType

    fun deleteById(id:Long)

    fun findPage(actionTypeQuery: ActionTypeQuery):PageResult

    fun findById(id:Long):ActionType

    fun findByActionName(actionName:String):ActionType?
}