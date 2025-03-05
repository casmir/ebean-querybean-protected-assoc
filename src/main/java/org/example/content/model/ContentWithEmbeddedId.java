package org.example.content.model;

import io.ebean.Model;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.common.embedded.EmbeddableId;

@Entity
@Table(name="product_history")
public class ContentWithEmbeddedId extends Model {

    @EmbeddedId
    private EmbeddableId embeddableId;

    @Column(length=50)
    private String name;

    public EmbeddableId getEmbeddableId() {
        return embeddableId;
    }

    public void setEmbeddableId(EmbeddableId embeddableId) {
        this.embeddableId = embeddableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
