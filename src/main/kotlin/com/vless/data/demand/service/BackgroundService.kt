package com.vless.data.demand.service

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.vless.data.demand.mapper.BackgroundMapper
import com.vless.data.demand.model.Background
import com.vless.data.demand.query.BackgroundQuery
import com.vless.data.demand.repository.BackgroundRepository
import com.vless.data.demand.result.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BackgroundService : BackgroundServiceAware {



    @Autowired
    lateinit var backgroundRepository: BackgroundRepository

    @Autowired
    lateinit var backgroundMapper: BackgroundMapper


    override fun save(background: Background): Background = backgroundRepository.save(background)

    override fun deleteById(id: Long) = backgroundRepository.deleteById(id)

    override fun findPage(backgroundQuery: BackgroundQuery): PageResult {
        PageHelper.startPage<Background>(backgroundQuery.page,backgroundQuery.limit)
        val list:List<Background> = backgroundMapper.selectAll(backgroundQuery)
        val pageInfo:PageInfo<Background> = PageInfo(list)
        return PageResult(pageInfo.total,list)
    }

    override fun findById(id: Long): Background = backgroundRepository.findById(id).get()

    override fun findByBackgroundName(backgroundName: String): Background = backgroundRepository.findByBackgroundName(backgroundName)
}