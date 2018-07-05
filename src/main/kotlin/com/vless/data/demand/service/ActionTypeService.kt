package com.vless.data.demand.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.vless.data.demand.mapper.ActionTypeMapper
import com.vless.data.demand.model.ActionType
import com.vless.data.demand.query.ActionTypeQuery
import com.vless.data.demand.repository.ActionTypeRepository
import com.vless.data.demand.result.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ActionTypeService:ActionTypeServiceAware {


    @Autowired
    lateinit var actionTypeRepository: ActionTypeRepository
    @Autowired
    lateinit var actionTypeMapper: ActionTypeMapper


    override fun save(actionType: ActionType):ActionType {
        return actionTypeRepository.save(actionType)
    }

    override fun deleteById(id: Long) {
        actionTypeRepository.deleteById(id)
    }


    override fun findPage(actionTypeQuery: ActionTypeQuery): PageResult {
        PageHelper.startPage<ActionType>(actionTypeQuery.page,actionTypeQuery.limit)
        val actionTypeList:List<ActionType> = actionTypeMapper.selectAll(actionTypeQuery)
        val pageInfo:PageInfo<ActionType> = PageInfo(actionTypeList)
        return PageResult(pageInfo.total,actionTypeList)
    }

    override fun findByActionName(actionName: String): ActionType? = actionTypeRepository.findByActionName(actionName)

    override fun findById(id: Long): ActionType = actionTypeRepository.findById(id).get()
}