package com.example.pictgram.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pictgram.entity.User;
import com.example.pictgram.entity.User.Authority;
import com.example.pictgram.form.UserForm;
import com.example.pictgram.repository.UserRepository;

/**
 * ユーザ関連コントローラー.
 * @author matsumotoyuyya
 *
 */
@Controller
public class UsersController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * ユーザー登録画面に遷移します.
	 * @param model　モデル
	 * @return ユーザー登録画面
	 */
	@GetMapping(path = "/users/new")
	public String newUser(Model model) {
		model.addAttribute("form", new UserForm());
		return "users/new";
	}

	/**
	 * ユーザ登録を行います.
	 * @param form　フォーム
	 * @param result　バリデーション
	 * @param model モデル
	 * @return　ユーザ登録完了画面.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute("form") UserForm form, BindingResult result, Model model,
			RedirectAttributes redirAttrs, Locale locale) {
		String name = form.getName();
		String email = form.getEmail();
		String password = form.getPassword();
		String passwordConfirmation = form.getPasswordConfirmation();
		System.out.println("メール" + email);
		if (repository.findByUsername(email) != null) {
			 FieldError fieldError = new FieldError(result.getObjectName(), "email", messageSource.getMessage("users.create.error.1", new String[] {}, locale));			result.addError(fieldError);
		}
		if (result.hasErrors()) {
			model.addAttribute("hasMessage", true);
			model.addAttribute("class", "alert-danger");
			model.addAttribute("message", messageSource.getMessage("users.create.flash.1", new String[] {}, locale));			return "users/new";
		}

		User entity = new User(email, name, passwordEncoder.encode(password), Authority.ROLE_USER);
		repository.saveAndFlush(entity);
		model.addAttribute("hasMessage", true);
		model.addAttribute("class", "alert-info");
		model.addAttribute("message", "ユーザー登録が完了しました。");
		return "layouts/complete";
	}
}
