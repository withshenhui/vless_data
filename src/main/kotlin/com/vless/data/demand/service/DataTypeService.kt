package com.vless.data.demand.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.vless.data.demand.mapper.DataTypeMapper
import com.vless.data.demand.model.DataType
import com.vless.data.demand.query.DataTypeQuery
import com.vless.data.demand.repository.DataTypeRepository
import com.vless.data.demand.result.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataTypeService:DataTypeServiceAware {


    @Autowired
    lateinit var dataTypeRepository: DataTypeRepository

    @Autowired
    lateinit var dataTypeMapper: DataTypeMapper


    override fun save(dataType: DataType):DataType {
        return dataTypeRepository.save(dataType)
    }

    override fun deleteById(id: Long) {
        dataTypeRepository.deleteById(id)
    }

    override fun findByDataName(dataName: String):DataType? =
            dataTypeRepository.findByDataName(dataName)

    override fun findPage(dataTypeQuery: DataTypeQuery): PageResult {
        PageHelper.startPage<DataType>(dataTypeQuery.page,dataTypeQuery.limit)
        val demandList:List<DataType> = dataTypeMapper.selectAll(dataTypeQuery)
        val pageInfo:PageInfo<DataType> = PageInfo(demandList)
        return PageResult(pageInfo.total,demandList)
    }

}