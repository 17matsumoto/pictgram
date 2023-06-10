package com.example.pictgram.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * セッション関連コントローラー.
 * @author matsumotoyuyya
 *
 */
@Controller
public class SessionsController {

	@Autowired
	   private MessageSource messageSource;
	
    /**
     * ログイン画面に遷移します.
     * @return ログイン画面
     */
    @GetMapping(path = "/login")
    public String index() {
        return "sessions/new";
    }

    /**
     * ログイン失敗のメッセージを表示します.
     * @param model モデル
     * @return ログイン画面
     */
    @GetMapping(path = "/login-failure")
    public String loginFailure(Model model ,Locale locale) {
        model.addAttribute("hasMessage", true);
        model.addAttribute("class", "alert-danger");
        model.addAttribute("message", messageSource.getMessage("sessions.loginFailure.flash", new String[] {}, locale));
        return "sessions/new";
    }

    /**
     * ログアウト完了画面のメッセージを表示します.
     * @param model モデル
     * @return　ログイン完了画面
     */
    @GetMapping(path = "/logout-complete")
    public String logoutComplete(Model model, Locale locale) {
        model.addAttribute("hasMessage", true);
        model.addAttribute("class", "alert-info");
        model.addAttribute("message", messageSource.getMessage("sessions.logoutComplete.flash", new String[] {}, locale));
        return "layouts/complete";
    }
}
