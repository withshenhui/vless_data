package com.vless.data.demand.controller

import com.vless.data.common.BizException
import com.vless.data.demand.model.Background
import com.vless.data.demand.query.BackgroundQuery
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.service.BackgroundServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/background")
class BackgroundController {

    @Autowired
    lateinit var backgroundService: BackgroundServiceAware

    @PostMapping("/save")
    fun save(@RequestBody @Valid background: Background, result: BindingResult):Background {
        return if(result.hasErrors()){
            throw BizException("save background error")
        }else if(backgroundService.findByBackgroundName(background.backgroundName!!)!= null){
            throw BizException("该背景名称已经存在")
        }else{
            backgroundService.save(background)
        }
    }

    @RequestMapping("/update",method = arrayOf(RequestMethod.POST))
    fun update(@RequestBody @Valid background: Background, result: BindingResult):Background{
        return if(result.hasErrors()){
            throw BizException("update background error")
        }else if(backgroundService.findByBackgroundName(background.backgroundName!!)!= null&&backgroundService.findByBackgroundName(background.backgroundName!!)!!.id!=background.id){
            throw BizException("该背景名称已经存在")
        }else{
            backgroundService.save(background)
        }
    }

    @RequestMapping("/remove/{id}",method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id:Long) = backgroundService.deleteById(id)

    @GetMapping("/list")
    fun findPage(backgroundQuery: BackgroundQuery):PageResult = backgroundService.findPage(backgroundQuery)
}