package org.example.common.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class EmbeddableId {

    @Column
    private Long id;

    @Column(length=50)
    private String other;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddableId that = (EmbeddableId) o;
        return Objects.equals(id, that.id) && Objects.equals(other, that.other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, other);
    }
}
