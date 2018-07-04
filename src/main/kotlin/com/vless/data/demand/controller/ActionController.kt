package com.vless.data.demand.controller

import com.vless.data.common.BizException
import com.vless.data.demand.model.Action
import com.vless.data.demand.query.ActionQuery
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.service.ActionServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/action")
class ActionController {

    @Autowired
    lateinit var actionService: ActionServiceAware

    @PostMapping("/save")
    fun save(@RequestBody @Valid action: Action,result:BindingResult):Action{
        action.gmtCreate=Date()
        return if(result.hasErrors())
            throw BizException("提交信息有误")
        else if(actionService.findByActionName(action.actionName!!)!=null)
            throw BizException("该行为名称已经存在")
        else
            actionService.save(action)
    }


    @PostMapping("/update")
    fun update(@RequestBody @Valid action:Action,result: BindingResult):Action{
        action.gmtModified=Date()
        return if(result.hasErrors())
            throw BizException("提交信息有误")
        else if(actionService.findByActionName(action.actionName!!)!=null&&actionService.findByActionName(action.actionName!!)!!.id!=action.id)
            throw BizException("该行为名称已经存在")
        else
            actionService.save(action)
    }


    @RequestMapping("/remove/{id}",method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id:Long) = actionService.delete(id)


    @GetMapping("/list")
    fun findPage(actionQuery: ActionQuery):PageResult = actionService.findPage(actionQuery)

}