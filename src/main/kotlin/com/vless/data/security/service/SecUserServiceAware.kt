package com.vless.data.security.service

import com.vless.data.security.model.SecRes
import com.vless.data.security.model.SecRole
import com.vless.data.security.result.SecUserResult

interface SecUserServiceAware {

    fun login(username:String,password:String):SecUserResult

    fun findRoleByUserId(userId:Long):SecRole

    fun findResListByUserId(userId:Long):List<SecRes>

    fun findByUsername(username:String):SecUserResult
}