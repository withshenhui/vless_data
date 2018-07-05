package com.vless.data.demand.repository

import com.vless.data.demand.model.Background
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BackgroundRepository:CrudRepository<Background,Long> {

    fun findByBackgroundName(backgroundName:String):Background?
}