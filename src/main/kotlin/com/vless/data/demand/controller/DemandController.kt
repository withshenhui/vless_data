package com.vless.data.demand.controller

import com.vless.data.common.BizException
import com.vless.data.demand.model.Demand
import com.vless.data.demand.query.DemandQuery
import com.vless.data.demand.result.DemandDetailResult
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.service.DemandDetailServiceAware
import com.vless.data.demand.service.DemandServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/api/demand")
@RestController
class DemandController {


    @Autowired
    lateinit var demandService: DemandServiceAware

    @Autowired
    lateinit var demandDetailService: DemandDetailServiceAware


    @PostMapping("/save")
    fun saveDemand(@RequestBody @Valid demand:Demand,result:BindingResult):Demand {

        return if(result.hasErrors()){
            throw BizException("提交信息有误")
        }else{
            demandService.save(demand)
        }
    }


    @GetMapping("/list")
    fun findAllDemands(demand:DemandQuery):PageResult
            =demandService.findPage(demand)


    @GetMapping("/detail/{demandId}")
    fun findDemandDetail(@PathVariable demandId:Long):List<DemandDetailResult> = demandDetailService.findByDemandId(demandId)
}