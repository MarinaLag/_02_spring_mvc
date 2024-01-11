package by.itclass.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyFistSpringWebMvcSuperController {

    @GetMapping(value = "/")
    public String viewIndex() {
        return "index";
    }

    @GetMapping(value = "/oldApproach") //адрес
    public String passParamOldApproach(HttpServletRequest req) {
        var stringParam = req.getParameter("param1");
        var intParam = Integer.parseInt(req.getParameter("param2"));
        req.setAttribute("strPar", stringParam);
        req.setAttribute("intPar", intParam);
        return "main";
        // http://localhost:8080/oldApproach?param1=gdg&param2=123
    }

    @GetMapping(value = "/springApproach")
    public String passParamSpringApproach(
            @RequestParam(name = "par1") String name,
            @RequestParam(name = "par2", required = false) Integer age,
            //required = false может и без этого параметра
            //с примитивами не работает int = Integer
            HttpServletRequest req) {

        req.setAttribute("strPar", name);
        req.setAttribute("intPar", age);
        return "main";
        // http://localhost:8080/springApproach?par1=gdg&par2=123
    }

    @GetMapping(value = "/storeInSession")
    public String passParamSpringApproach(
            @RequestParam(name = "par1") String name,
            @RequestParam(name = "par2") int age,
            HttpSession session) {
// параметры храняться в сессии
        session.setAttribute("strPar", name); //!!!!!!!
        session.setAttribute("intPar", age);
        return "main";
        // http://localhost:8080/storeInSession?par1=gdg&par2=1235
    }

    @GetMapping(value = "/urlPart/{par1}/{par2}")  // !!!!!!
    public String passParamAsUrlPart(
            //PathVariable !!!!! удобно когда по иерархии
            @PathVariable(name = "par1") String name,
            @PathVariable(name = "par2") int age,
            HttpServletRequest req) {
        req.setAttribute("strPar", name);
        req.setAttribute("intPar", age);
        return "main";
        //http://localhost:8080/urlPart/Petty/25
    }

    @GetMapping(value = "/useModel")
    public String passParamSpringApproachStoreInModel(
            // когда много
            @RequestParam(name = "par1") String name,
            @RequestParam(name = "par2") int age,
            Model model) {              //!!!!!!!!!!!!!!
        model.addAttribute("strPar", name);
        model.addAttribute("intPar", age);
        return "main";
        //http://localhost:8080/useModel?par1=Misha&par2=12
    }

    @GetMapping(value = "/useModelAndView")
    // ModelAndView - если мы не знаем
    public ModelAndView passParamSpringApproachStoreInModelAndView( //!!!!!!!!!!!!!!!!!!
               @RequestParam(name = "par1") String name,
               @RequestParam(name = "par2") int age) {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("strPar",name);
        modelAndView.addObject("intPar",age);
        return modelAndView;
        //http://localhost:8080/useModelAndView?par1=Misha&par2=35
    }
}
