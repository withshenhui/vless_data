package com.vless.data.security.mapper

import com.vless.data.security.model.SecRes
import com.vless.data.security.model.SecRole
import com.vless.data.security.model.SecUser
import com.vless.data.security.query.SecUserQuery
import com.vless.data.security.result.SecUserResult
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface SecUserMapper {

    fun selectAll(secUserQuery: SecUserQuery):List<SecUser>

    fun selectCount(secUserQuery: SecUserQuery):Long

    @Select("SELECT r.* FROM sec_role r INNER JOIn sec_role_user ru ON " +
            "ru.role_id=r.id WHERE ru.user_id=#{userId}")
    fun selectRoleByUserId(@Param("userId") userId:Long):SecRole

    @Select("SELECT r.* FROM sec_res r INNER JOIn sec_role_res rr ON " +
            "rr.res_id=r.id INNER JOIN sec_role role ON role.id=rr.role_id " +
            "INNER JOIN sec_role_user ru ON ru.role_id=role.id WHERE ru.user_id=#{userId}")
    fun selectResListByUserId(@Param("userId") userId:Long):List<SecRes>

    @Select("SELECT * FROM sec_user WHERE username=#{username}")
    fun selectByUsername(@Param("username") username:String): SecUserResult
}