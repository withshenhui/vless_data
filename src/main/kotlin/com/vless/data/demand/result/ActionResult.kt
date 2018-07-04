package com.vless.data.demand.result

import com.vless.data.common.BaseResult
import com.vless.data.demand.enum.ProjectStatusEnum
import javax.persistence.EnumType
import javax.persistence.Enumerated

open class ActionResult:BaseResult() {

    var id:Long = 0

    var actionName:String = ""

    var actionTypeName:String = ""

    var actionTypeId:Long = 0

    var actionNo:String = ""

    @Enumerated(EnumType.STRING)
    var status: ProjectStatusEnum? = null

    var actionImages:String = ""

    var memo:String = ""




}