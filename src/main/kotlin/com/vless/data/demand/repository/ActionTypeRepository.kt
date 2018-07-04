package com.vless.data.demand.repository

import com.vless.data.demand.model.ActionType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ActionTypeRepository:CrudRepository<ActionType,Long>{

    fun findByActionName(actionName:String):ActionType?

}