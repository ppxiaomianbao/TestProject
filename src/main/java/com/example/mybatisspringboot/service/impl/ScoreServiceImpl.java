package com.example.mybatisspringboot.service.impl;

import com.example.mybatisspringboot.pojo.Score;
import com.example.mybatisspringboot.mapper.ScoreMapper;
import com.example.mybatisspringboot.service.ScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limx
 * @since 2019-11-09
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

}
