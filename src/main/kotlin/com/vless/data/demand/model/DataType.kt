package com.vless.data.demand.model

import com.vless.data.common.BaseEntity
import com.vless.data.demand.enum.ProjectStatusEnum
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name="v_data_type")
class DataType : BaseEntity() {


    @Column(name="data_name")
    @NotEmpty
    var dataName:String = ""

    @Column(name="memo")
    var memo:String? = null


    @Column(name="status")
    @Enumerated(EnumType.STRING)
    var status:ProjectStatusEnum? = null

}