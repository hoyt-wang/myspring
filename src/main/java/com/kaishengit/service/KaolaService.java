package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaType;

import java.util.List;

/**
 * Created by hoyt on 2017/11/4.
 */

public interface KaolaService {
    Kaola findById(Integer id);
    PageInfo<Kaola> findByPageNo(Integer pageNo);
    void save(Kaola kaola);
    void edit(Kaola kaola);
    void delete(Integer id);

    List<KaolaType> findAllType();
}
