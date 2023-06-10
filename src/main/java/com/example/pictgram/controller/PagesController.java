package com.example.pictgram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author matsumotoyuyya
 *トップページ関連コントローラー.
 */
@Controller
public class PagesController {
	
	
	/**
	 * トップページに遷移します.
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "pages/index";
	}

}
