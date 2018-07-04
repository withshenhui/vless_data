package com.vless.data.security.form

import javax.persistence.Entity
import javax.validation.constraints.NotEmpty

class LoginForm {

    @NotEmpty
    var username:String = ""

    @NotEmpty
    var password:String = ""
}