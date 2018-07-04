package com.vless.data.common

import com.fasterxml.jackson.annotation.JsonFormat
import com.vless.data.demand.service.DemandDetailServiceAware
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
open class BaseEntity : Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0

    @Column(name = "gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtCreate: Date = Date()

    @Column(name = "gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    var gmtModified: Date? = null


}