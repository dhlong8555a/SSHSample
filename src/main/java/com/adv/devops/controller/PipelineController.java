package com.adv.devops.controller;

import com.adv.devops.model.Pipeline;
import com.adv.devops.service.IPipelineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hailong.dang on 6/7/2017.
 */
@RestController
@RequestMapping("/pipelinecontroller")
public class PipelineController {
    private Logger log = LoggerFactory.getLogger(PipelineController.class);

    @Autowired
    IPipelineService pipelineService;

    @RequestMapping(path = "/pipeline", method = RequestMethod.GET)
    public ResponseEntity<?> getPipeline(@RequestParam(value = "id") int id) {
        log.info("Get pipeline with id {}", id);
        Pipeline pipeline = null;
        ResponseEntity<?> respEntity = null;
        pipeline = pipelineService.findById(id);
        if (pipeline == null) {
            log.error("Pipeline with id {} not found.", id);
            respEntity = new ResponseEntity("Pipeline with id " + id + "not found.", HttpStatus.NOT_FOUND);
        }
        else respEntity = new ResponseEntity<>(pipeline, HttpStatus.OK);

        return respEntity;
    }

    @RequestMapping(path = "/pipeline", method = RequestMethod.POST)
    public ResponseEntity<?> addPipeline(@RequestBody Pipeline pipeline) {
        log.info("Add pipeline:{},{}", pipeline.getName(), pipeline.getGitUrl());
        ResponseEntity<?> respEntity = null;
        pipelineService.savePipeline(pipeline);
        respEntity = new ResponseEntity<>(pipeline, HttpStatus.OK);

        return respEntity;
    }

    @RequestMapping(path = "/pipeline", method = RequestMethod.DELETE)
    public ResponseEntity<?> delPipeline(@RequestParam(value = "id") int id)
    {
        log.info("Delete pipeline:{}"+id);
        ResponseEntity<?> respEntity = null;
        pipelineService.deletePipeline(id);
        respEntity = new ResponseEntity<>(HttpStatus.OK);
        return respEntity;
    }

    @RequestMapping(path = "/all/pipelines", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPipelines(){
        log.info("Get all pipeline");
        ResponseEntity<?> respEntity = null;
        List<Pipeline> pipelines = pipelineService.getAllPipelines();
        respEntity = new ResponseEntity<>(pipelines, HttpStatus.OK);
        return respEntity;
    }
}
