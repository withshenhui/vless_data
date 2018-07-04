package com.vless.data.demand.controller

import com.vless.data.common.BizException
import com.vless.data.demand.model.DataType
import com.vless.data.demand.query.DataTypeQuery
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.service.DataTypeServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/datatype")
class DataTypeController {

    @Autowired
    lateinit var dataTypeService: DataTypeServiceAware

    @GetMapping("/list")
    fun findAllDemands(dataTypeQuery: DataTypeQuery):PageResult
            =dataTypeService.findPage(dataTypeQuery)

    @PostMapping("/save")
    fun save(@RequestBody @Valid dataType: DataType, result: BindingResult):DataType {
        println(dataType.dataName)
        dataType.gmtCreate= Date()
        return if (result.hasErrors()) {
           throw BizException("数据类型信息有错误")
        }else if(dataTypeService.findByDataName(dataType.dataName)!=null){
            throw BizException("该数据类型已存在")
        }else {
             dataTypeService.save(dataType)
        }
    }

    @PostMapping("/update")
    fun update(@RequestBody @Valid dataType: DataType, result: BindingResult):DataType  {
        dataType.gmtModified=Date()
        return when {
            result.hasErrors() -> {
                throw BizException("数据类型信息有错误")
            }
            dataTypeService.findByDataName(dataType.dataName) != null && (dataTypeService.findByDataName(dataType.dataName))!!.id != dataType.id -> {
                throw BizException("该数据类型已存在")
            }
            else -> {
                dataTypeService.save(dataType)
            }
        }
    }

    @RequestMapping("/remove/{id}",method = arrayOf(RequestMethod.DELETE))
    fun remove(@PathVariable id:Long)  {
        dataTypeService.deleteById(id)
    }
}