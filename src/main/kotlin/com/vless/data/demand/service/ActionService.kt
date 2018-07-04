package com.vless.data.demand.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.vless.data.demand.mapper.ActionMapper
import com.vless.data.demand.model.Action
import com.vless.data.demand.query.ActionQuery
import com.vless.data.demand.repository.ActionRepository
import com.vless.data.demand.result.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActionService : ActionServiceAware {



    @Autowired
    lateinit var actionRepository: ActionRepository

    @Autowired
    lateinit var actionMapper: ActionMapper


    override fun save(action: Action): Action = actionRepository.save(action)

    override fun delete(id: Long) = actionRepository.deleteById(id)

    override fun findPage(actionQuery: ActionQuery): PageResult {
        PageHelper.startPage<Action>(actionQuery.page,actionQuery.limit)
        val list:List<Action> = actionMapper.selectAll(actionQuery)
        val pageInfo:PageInfo<Action> = PageInfo(list)
        return PageResult(pageInfo.total,list)
    }

    override fun findById(id: Long): Action = actionRepository.findById(id).get()

    override fun findByActionName(actionName: String): Action? = actionRepository.findByActionName(actionName)

}