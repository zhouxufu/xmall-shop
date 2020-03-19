package com.xmall.user.web.convert;

import com.xmall.user.dto.UserPhoneRegisterDTO;
import com.xmall.user.web.request.UserPhoneRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author zhouxufu
 */
@Mapper
public interface UserRegisterConverter {

    UserRegisterConverter INSTANCE = Mappers.getMapper(UserRegisterConverter.class);

    /**
     * request对象转dto对象
     *
     * @param userPhoneRegisterRequest 前端请求参数
     * @return 转换后dto
     */
    @Mappings({})
    UserPhoneRegisterDTO requestToDTO(UserPhoneRegisterRequest userPhoneRegisterRequest);
}
