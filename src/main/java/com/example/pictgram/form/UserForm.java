package com.example.pictgram.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.pictgram.validation.constraints.PasswordEquals;

import lombok.Data;

/**
 * ユーザフォーム.
 * @author matsumotoyuyya
 *
 */
@Data
@PasswordEquals
public class UserForm {

    /**
     * 名前
     */
    @NotEmpty
    @Size(max = 100)
    private String name;

    /**
     * メールアドレス
     */
    @NotEmpty
    @Email
    private String email;

    /**
     * パスワード
     */
    @NotEmpty
    @Size(max = 20)
    private String password;

    /**
     * 確認用パスワード
     */
    @NotEmpty
    @Size(max = 20)
    private String passwordConfirmation;

}