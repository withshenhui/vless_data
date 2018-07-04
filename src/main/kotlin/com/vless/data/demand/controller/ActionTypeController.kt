package com.vless.data.demand.controller

import com.vless.data.common.BizException
import com.vless.data.demand.model.ActionType
import com.vless.data.demand.query.ActionTypeQuery
import com.vless.data.demand.result.PageResult
import com.vless.data.demand.service.ActionTypeServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/actiontype")
class ActionTypeController {



    @Autowired
    lateinit var actionTypeService: ActionTypeServiceAware


    //@CrossOrigin(origins = arrayOf("*"))
    @GetMapping("/list")
    fun findPage(actionTypeQuery: ActionTypeQuery):PageResult
            =actionTypeService.findPage(actionTypeQuery)

    @PostMapping("/save")
    fun save(@RequestBody @Valid actionType:ActionType,result:BindingResult):ActionType{
        actionType.gmtCreate= Date()
        return if(result.hasErrors())
            throw BizException("提交信息有误")
        else if(actionTypeService.findByActionName(actionType.actionName!!)!=null)
            throw BizException("该行为名称已经存在")
        else
            actionTypeService.save(actionType)
    }

    @PostMapping("/update")
    fun update(@RequestBody @Valid actionType: ActionType, result: BindingResult): ActionType {
        actionType.gmtModified=Date()
        return if(result.hasErrors())
            throw BizException("提交信息有误")
        else if(actionTypeService.findByActionName(actionType.actionName!!)!=null&&actionTypeService.findByActionName(actionType.actionName!!)!!.id!=actionType.id)
            throw BizException("该行为名称已经存在")
        else
            actionTypeService.save(actionType)
    }

    @RequestMapping("/remove/{id}",method = arrayOf(RequestMethod.DELETE))
    fun remove(@PathVariable id:Long)  {
        actionTypeService.deleteById(id)
    }
}