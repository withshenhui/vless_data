package com.vless.data.demand.repository

import com.vless.data.demand.model.Action
import com.vless.data.demand.model.Demand
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DemandRepository:CrudRepository<Demand,Long> {

}