package com.adv.devops.service;

import com.adv.devops.model.Pipeline;

import java.util.List;

/**
 * Created by hailong.dang on 6/8/2017.
 */
public interface IPipelineService {
    Pipeline findById(int id);

    void savePipeline(Pipeline pipeline);

    void deletePipeline(int id);

    List<Pipeline> getAllPipelines();
}
