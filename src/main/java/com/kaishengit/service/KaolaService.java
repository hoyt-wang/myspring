package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaType;

import java.util.List;
import java.util.Map;

/**
 * Created by hoyt on 2017/11/4.
 */

public interface KaolaService {
    Kaola findById(Integer id);
    PageInfo<Kaola> findByPageNo(Integer pageNo);
    PageInfo<Kaola> findByQueryParamWithType(Integer pageNo, Map<String,Object> queryParam);
    void save(Kaola kaola);
    void edit(Kaola kaola);
    void delete(Integer id);

    List<KaolaType> findAllType();
    List<String> findAllPlace();
}
