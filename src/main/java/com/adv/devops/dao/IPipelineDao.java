package com.adv.devops.dao;

import com.adv.devops.model.Pipeline;

import java.util.List;

/**
 * Created by hailong.dang on 6/8/2017.
 */
public interface IPipelineDao {

    Pipeline findById(int id);

    void savePipeline(Pipeline pipeline);

    void deletePipeline(Pipeline pipeline);

    List<Pipeline> getAllPipeline();
}
