package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaExample;
import com.kaishengit.entity.KaolaType;
import com.kaishengit.entity.KaolaTypeExample;
import com.kaishengit.mapper.KaolaMapper;
import com.kaishengit.mapper.KaolaTypeMapper;
import com.kaishengit.service.KaolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hoyt on 2017/11/4.
 */

@Service
public class KaolaServiceImpl implements KaolaService {

    @Autowired
    private KaolaMapper kaolaMapper;

    @Autowired
    private KaolaTypeMapper kaolaTypeMapper;

    @Override
    public Kaola findById(Integer id) {
        return kaolaMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Kaola> findByPageNo(Integer pageNo) {
        PageHelper.startPage(pageNo,10);
        KaolaExample kaolaExample = new KaolaExample();
        kaolaExample.setOrderByClause("id desc");
        List<Kaola> list = kaolaMapper.selectByExample(kaolaExample);
        return new PageInfo<Kaola>(list);
    }

    @Override
    public void save(Kaola kaola) {
        kaola.setCommentNum(0);
        kaolaMapper.insert(kaola);
    }

    @Override
    public void edit(Kaola kaola) {
        kaolaMapper.updateByPrimaryKeySelective(kaola);
    }

    @Override
    public void delete(Integer id) {
        kaolaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<KaolaType> findAllType() {
        return kaolaTypeMapper.selectByExample(new KaolaTypeExample());
    }
}
