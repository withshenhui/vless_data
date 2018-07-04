package com.vless.data.security.model

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name="sec_res")
class SecRes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long =0

    @NotEmpty
    @Column(name="name")
    var name:String = ""

    @NotEmpty
    @Column(name="source")
    var source:String = ""

    @NotNull
    @Column(name="type")
    var type:Int = 1

    @NotNull
    @Column(name="parent_id")
    var parentId:Long = 0

    @Column(name="memo")
    var memo:String =""

    @NotEmpty
    @Column(name="auth")
    var auth:String = ""

    @NotNull
    @Column(name="sorts")
    var sorts:Int = 1

    @NotNull
    @Column(name="status")
    var status:Int = 1
}