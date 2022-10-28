package course.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {


//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("Hello !" + name + "" + surname);
//        return "first/hello";
//    }



@GetMapping("/hello")
public String helloPage(@RequestParam("name") String name,
                        @RequestParam("surname") String surname,
                        Model model){
//    System.out.println("Hello !" + name + "" + surname);
    model.addAttribute("message","Hello !" + name + "" + surname);
    return "first/hello";

}
    @GetMapping("/by")
    public String byPage(){
        return "first/by";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             Model model,
                             @RequestParam("action") String action) {
    double result;
    switch (action){
        case "multiplication":
            result = a * b;
            break;
        case "division":
            result = a / (double)b;
            break;
        case "substruction":
            result = a - b;
            break;
        case "addition":
            result = a + b;
            break;
        default:
            result = 1111;
            break;

    }
    model.addAttribute("result", result);
    return "first/calculator";
    }
}
