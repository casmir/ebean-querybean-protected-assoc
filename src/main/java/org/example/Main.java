package org.example;

import io.ebean.DB;
import org.example.common.embedded.EmbeddableId;
import org.example.content.dao.ContentWithEmbeddedIdDao;
import org.example.content.model.ContentWithEmbeddedId;

public class Main {


    public static void main(String[] args) {

        System.out.println("running ...");
        DB.getDefault();

        var productHistory = new ContentWithEmbeddedId();
        productHistory.setName("test");
        var embeddableId = new EmbeddableId();
        embeddableId.setId(1L);
        embeddableId.setOther("other");
        productHistory.setEmbeddableId(embeddableId);

        productHistory.save();

        var dao = new ContentWithEmbeddedIdDao();
        var ok = dao.getAllOk();
        System.out.println("records " + ok.size());

        var wrong = dao.getAllWrong();
        System.out.println("records " + wrong);

        System.out.println("done");
    }
}