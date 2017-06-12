package com.adv.devops.dao;

import com.adv.devops.model.Pipeline;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hailong.dang on 6/8/2017.
 */
@SuppressWarnings("JpaQlInspection")
@Repository("pipelineDao")
public class PipelineDaoImpl extends AbstractDao<Integer, Pipeline> implements IPipelineDao {
    @Override
    public Pipeline findById(int id) {
        return getByKey(id);
    }

    @Override
    public void savePipeline(Pipeline pipeline) {
        persist(pipeline);
    }

    @Override
    public void deletePipeline(Pipeline pipeline) {
        delete(pipeline);
    }

    @Override
    public List<Pipeline> getAllPipeline() {
        String hql  = "FROM Pipeline AS p ORDER BY p.id ASC";
        Query query = getSession().createQuery(hql);
        List<Pipeline> results = (List<Pipeline>)query.list();
        return results;
    }
}
