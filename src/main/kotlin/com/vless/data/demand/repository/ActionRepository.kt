package com.vless.data.demand.repository

import com.vless.data.demand.model.Action
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActionRepository:CrudRepository<Action,Long> {

    fun findByActionName(actionName:String):Action?
}