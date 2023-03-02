package org.example.service;


import feign.Param;
import feign.RequestLine;

/**
 * 调用App接口
 *
 * @author user
 */
public interface AppCloud {

    @RequestLine("GET /app/changePoint?id={id}&point={point}")
    void changePoint(@Param("id") Long id, @Param("point") Integer point);

}
