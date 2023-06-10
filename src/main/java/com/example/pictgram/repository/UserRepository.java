package com.example.pictgram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pictgram.entity.User;

/**
 * @author matsumotoyuyya
 *ユーザ関連リポジトリー.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * ユーザ名を検索します.
     * @param username ユーザ名
     * @return　検索されたユーザー情報
     */
    User findByUsername(String username);
}
