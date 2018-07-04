package com.vless.data.demand.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.vless.data.demand.mapper.DemandDetailMapper
import com.vless.data.demand.model.DemandDetail
import com.vless.data.demand.query.DemandDetailQuery
import com.vless.data.demand.repository.DemandDetailRepository
import com.vless.data.demand.result.DemandDetailActionResult
import com.vless.data.demand.result.DemandDetailResult
import com.vless.data.demand.result.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DemandDetailService : DemandDetailServiceAware {


    @Autowired
    lateinit var detailRepository: DemandDetailRepository
    @Autowired
    lateinit var detailMapper:DemandDetailMapper

    override fun save(demandDetail: DemandDetail) =detailRepository.save(demandDetail)

    override fun deleteById(id: Long) =detailRepository.deleteById(id)

    override fun findByDemandId(demandId: Long): List<DemandDetailResult> = detailMapper.selectBackgroundByDemandId(demandId)

    override fun findActionByDemandIdAndBackgroundId(demandDetailQuery: DemandDetailQuery): List<DemandDetailActionResult> {
        return detailMapper.findActionByDemandIdAndBackgroundId(demandDetailQuery)
    }
}