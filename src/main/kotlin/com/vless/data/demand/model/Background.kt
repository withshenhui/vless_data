package com.vless.data.demand.model

import com.vless.data.common.BaseEntity
import com.vless.data.demand.enum.ProjectStatusEnum
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name="v_background")
class Background : BaseEntity() {


    @Column(name="background_no")
    @NotEmpty
    var backgroundNo:String? = null

    @Column(name="background_name")
    @NotEmpty
    var backgroundName:String? = null

    @Column(name="background_images")
    @NotEmpty
    var backgroundImages:String? = null

    @Column(name="memo")
    var memo:String? = null

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    @NotNull
    var status:ProjectStatusEnum? = null

}