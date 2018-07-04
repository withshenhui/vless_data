package com.vless.data.security.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name="sec_role_res")
class SecRoleRes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long =0

    @NotNull
    @Column(name="role_id")
    var roleId:Long =0

    @NotNull
    @Column(name="res_id")
    var resId:Long = 0
}