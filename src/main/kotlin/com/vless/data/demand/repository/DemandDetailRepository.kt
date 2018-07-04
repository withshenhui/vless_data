package com.vless.data.demand.repository

import com.vless.data.demand.model.DemandDetail
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DemandDetailRepository:CrudRepository<DemandDetail,Long> {

}