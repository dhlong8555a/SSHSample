package com.adv.devops.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hailong.dang on 6/27/2017.
 */
@RestController
@RequestMapping("/projectcontroller")
public class ProjectController {
    private Logger log = LoggerFactory.getLogger(PipelineController.class);
    @RequestMapping(path = "/all/projects", method = RequestMethod.GET)
    public ResponseEntity<?> listProjects(@RequestParam(value = "workspace_id") int id,
            @RequestParam( value = "startnum", required=false) int startNum,
            @RequestParam(value="count", required = false) int count) {
        log.info("Get pipeline with workspace_id {}, startNum {}, count {}", id, startNum, count);
        ResponseEntity<?> respEntity = null;
        String retStr = "{" +
                "\"total_count\": 1," +
                "\"projects\":[" +
                      "{"+
                            "\"workspace_id\": 1,"+
                            "\"id\": 1,"+
                            "\"name\":\"ushop\","+
                            "\"description\":\"ushop\","+
                            "\"is_active\": true,"+
                            "\"create_time\": \"2017/05/01 10:00:00\" ,"+
                            "\"update_time\": \"2017/05/01 10:00:00\""+
                        "}"+
                "]"+
                "}";

        respEntity = new ResponseEntity<>(retStr, HttpStatus.OK);
        return respEntity;
    }
}
