package com.ssm.forwardandredirect.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    // 请求重定向
    // 带参数
    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public String testRedirect(RedirectAttributes attr) {

        // 1.使用RedirectAttributes的addAttribute方法传递参数会跟随在URL后面，如代码即为http:/index.action?a=a
        attr.addAttribute("a", "a");

        // 2.使用addFlashAttribute不会跟随在URL后面，会把该参数值暂时保存于session，待重定向url获取该参数后从session中移除，
        // 这里的redirect必须是方法映射路径，jsp无效。
        // 你会发现redirect后的jsp页面中b只会出现一次，刷新后b再也不会出现了，
        // 这验证了上面说的，b被访问后就会从session中移除。对于重复提交可以使用此来完成
        // 另外，如果使用了RedirectAttributes作为参数，但是没有进行redirect呢？
        // 这种情况下不会将RedirectAttributes参数传递过去，默认传forward对应的model，
        // 官方的建议是： p:ignoreDefaultModelOnRedirect="true" />
        // 设置下RequestMappingHandlerAdapter
        // 的ignoreDefaultModelOnRedirect属性,这样可以提高效率，避免不必要的检索。
        attr.addFlashAttribute("b", "b");

        return "redirect:/index.action";
    }

    // 请求重定向
    // 无参数
    @RequestMapping(value = "/noparam", method = RequestMethod.GET)
    public String testRedirect() {

        return "redirect:/index.action";
    }

}
