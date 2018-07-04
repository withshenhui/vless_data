package com.vless.data.demand.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.vless.data.common.BizException
import com.vless.data.demand.mapper.DemandMapper
import com.vless.data.demand.model.Demand
import com.vless.data.demand.query.DemandQuery
import com.vless.data.demand.repository.DemandRepository
import com.vless.data.demand.result.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DemandService:DemandServiceAware {



    @Autowired
    lateinit var demandRepository: DemandRepository

    @Autowired
    lateinit var demandMapper: DemandMapper



    override fun save(demand: Demand):Demand {
        return demandRepository.save(demand)
    }

    override fun deleteById(id: Long) {
        demandRepository.deleteById(id)
    }

    override fun findPage(demand: DemandQuery): PageResult {
        PageHelper.startPage<Demand>(demand.page,demand.limit)
        val demandList:List<Demand>? = demandMapper.selectAll(demand)
        val pageInfo:PageInfo<Demand> = PageInfo(demandList)
        return PageResult(pageInfo.total,demandList)

    }

    override fun findById(id: Long): Demand {
        /*
         return if(demandRepository.findById(id).isPresent){
             demandRepository.findById(id).get()
         }else{
             throw BizException("no data")
         }
        */

        //return demandRepository.findById(id)?.get()
        return when{
            demandRepository.findById(id).isPresent -> {
                demandRepository.findById(id).get()
            }
            else -> {
                throw BizException("no data")
            }
        }
    }

}