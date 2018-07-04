package com.vless.data.security.controller

import com.vless.data.security.result.SecUserResult
import com.vless.data.security.service.SecUserServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class SecUserController {

    @Autowired
    lateinit var secUserService:SecUserServiceAware


    @GetMapping("/{username}")
    fun findByUsername(@PathVariable username:String):SecUserResult = secUserService.findByUsername(username)

}