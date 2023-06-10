package com.example.pictgram.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

/**
 * @author matsumotoyuyya
 * 登録日時関連エンティティー.
 *
 */
@MappedSuperclass
@Data
public class AbstractEntity {
    /**
     * 登録日時
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 更新日時
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        Date date = new Date();
        setCreatedAt(date);
        setUpdatedAt(date);
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdatedAt(new Date());
    }
}