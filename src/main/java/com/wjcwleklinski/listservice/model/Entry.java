package com.wjcwleklinski.listservice.model;

import com.wjcwleklinski.listservice.model.entity.CommonEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ETR_ENTRIES")
@Getter
@Setter
@AttributeOverrides({
        @AttributeOverride(name = "code", column = @Column(name = "ETR_CODE")),
        @AttributeOverride(name = "id", column = @Column(name = "ETR_ID"))
})
@SequenceGenerator(name = "COMMON_GEN", sequenceName = "ETR_SEQUENCE")
public class Entry extends CommonEntity {

    @RequiredArgsConstructor
    @Getter
    public enum Priority {
        HIGH,
        MEDIUM,
        LOW
    }

    @Column(name = "ETR_PRIORITY")
    private String priority;

    @Column(name = "ETR_NAME")
    private String name;

    @Column(name = "ETR_DESCRIPTION")
    private String description;

    @Column(name = "ETR_IMAGE")
    private String image;

    @ManyToOne
    @JoinColumn(name = "ETR_CHL_ID")
    private CheckList checkList;
}
