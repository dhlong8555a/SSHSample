package com.adv.devops.service;

import com.adv.devops.dao.IPipelineDao;
import com.adv.devops.model.Pipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hailong.dang on 6/8/2017.
 */
@Transactional
@Service("pipelineService")
public class PipelineServiceImpl implements IPipelineService {

    @Autowired
    private IPipelineDao pipelineDao;

    @Override
    public Pipeline findById(int id) {
        return pipelineDao.findById(id);
    }

    @Override
    public void savePipeline(Pipeline pipeline) {
        pipelineDao.savePipeline(pipeline);
    }

    @Override
    public void deletePipeline(int id) {
        Pipeline pipeline = pipelineDao.findById(id);
        if(pipeline != null) pipelineDao.deletePipeline(pipeline);
    }

    @Override
    public List<Pipeline> getAllPipelines() {
        return pipelineDao.getAllPipeline();
    }
}
