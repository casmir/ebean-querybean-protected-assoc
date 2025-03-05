package org.example.content.dao;

import io.ebean.DB;
import io.ebean.annotation.Transactional;
import org.example.content.model.ContentWithEmbeddedId;
import org.example.content.model.query.QContentWithEmbeddedId;

import java.util.List;

public class ContentWithEmbeddedIdDao {

    @Transactional
    public List<ContentWithEmbeddedId> getAllWrong() {
        return new QContentWithEmbeddedId().select(QContentWithEmbeddedId.alias().embeddableId).findList();
    }

    @Transactional
    public List<ContentWithEmbeddedId> getAllOk() {
        return DB.find(ContentWithEmbeddedId.class)
                .select("embeddableId")
                .findList();
    }


}
