package com.service.mock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@DynamicUpdate
@Table(name = "api_mapping")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_id")
    private Long keyId;
}
