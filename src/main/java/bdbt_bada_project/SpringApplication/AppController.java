package bdbt_bada_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Configuration
@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");

        registry.addViewController("/tabela_hurtownie").setViewName("tebela_hurtownie");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/tabela_hurtownie";  // "redirect:/main_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else {
                return "redirect:/index";
            }
        }
        @Autowired
        private HurtowniaDAO dao;

        @RequestMapping("/tabela_hurtownie")
        public String viewHomePage(Model model) {
            /* Import java.util.List */
            List<Hurtownia> listHurtownia = dao.list();
            model.addAttribute("listHurtownia", listHurtownia);
            return "tabela_hurtownie";
        }

        @RequestMapping("/new")
        public String showNewForm(Model model){
            Hurtownia hurtownia = new Hurtownia();
            model.addAttribute("hurtownia", hurtownia);
            return "new_form";
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save (@ModelAttribute("hurtownia") Hurtownia hurtownia) {

            dao.save(hurtownia);
            return "redirect:/";
        }

        @RequestMapping("/edit/{nrHurtowni}")
        public ModelAndView showEditForm(@PathVariable(name = "nrHurtowni") int nrHurtowni) {
            ModelAndView mav = new ModelAndView("edit_form");
            Hurtownia hurtownia = dao.get(nrHurtowni);
            mav.addObject("hurtownia", hurtownia);

            return mav;
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String update(@ModelAttribute("hurtownia") Hurtownia hurtownia) {
            dao.update(hurtownia);

            return "redirect:/tabela_hurtownie";
        }

        @RequestMapping("/delete/{nrHurtowni}")
        public String delete(@PathVariable(name = "nrHurtowni") int nrHurtowni) {
            dao.delete(nrHurtowni);

            return "redirect:/tabela_hurtownie";
        }

    }


    @RequestMapping(value={"/tebela_hurtownie"})
    public String showAdminPage(Model model) {
        return "tebela_hurtownie";
    }

//    @RequestMapping(value={"/main_admin"})
//    public String showAdminPage(Model model) {
//        return "admin/main_admin";
//    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}