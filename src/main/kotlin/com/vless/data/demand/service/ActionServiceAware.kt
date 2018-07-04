package com.vless.data.demand.service

import com.vless.data.demand.model.Action
import com.vless.data.demand.query.ActionQuery
import com.vless.data.demand.result.PageResult

interface ActionServiceAware  {

    fun save(action:Action):Action

    fun delete(id:Long)

    fun findPage(actionQuery: ActionQuery):PageResult

    fun findById(id:Long) : Action

    fun findByActionName(actionName:String):Action?
}