package com.test.nexu.TestNexu.structure.model.infraestructure.adapter.output.entity;

import com.test.nexu.TestNexu.structure.brand.infraestructure.adapter.output.entity.Brand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "average_price", nullable = true)
    private Double average_price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brandId", nullable = false)
    private Brand brandId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Model brand = (Model) o;
        return Objects.equals(id, brand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
