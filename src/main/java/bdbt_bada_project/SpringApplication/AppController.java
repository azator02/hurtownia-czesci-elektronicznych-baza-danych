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
                return "redirect:/main_admin";
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
        @Autowired
        private ProduktDAO daoP;
        @Autowired
        private KlientDAO daoK;
        @Autowired
        private AdresDAO daoA;

        @RequestMapping("/tabela_hurtownie")
        public String viewAdminHurtownie(Model model) {
            /* Import java.util.List */
            List<Hurtownia> listHurtownia = dao.list();
            model.addAttribute("listHurtownia", listHurtownia);
            return "admin/tabela_hurtownie";
        }

        @RequestMapping("/newHurtownie")
        public String showNewFormHurtownie(Model model){
            Hurtownia hurtownia = new Hurtownia();
            model.addAttribute("hurtownia", hurtownia);
            return "admin/new_form_hurtownie";
        }

        @RequestMapping(value = "/saveHurtownie", method = RequestMethod.POST)
        public String save(@ModelAttribute("hurtownia") Hurtownia hurtownia) {
            try {
                dao.saveHurtownie(hurtownia);
            }
            catch (Exception e) {
                return "redirect:/tabela_hurtownie";
            }
            return "redirect:/tabela_hurtownie";
        }

        @RequestMapping("/editHurtownie/{nrHurtowni}")
        public ModelAndView showEditFormHurtownie(@PathVariable(name = "nrHurtowni") int nrHurtowni) {
            ModelAndView mav = new ModelAndView("admin/edit_form_hurtownie");
            Hurtownia hurtownia = dao.getHurtownie(nrHurtowni);
            mav.addObject("hurtownia", hurtownia);

            return mav;
        }

        @RequestMapping(value = "/updateHurtownie", method = RequestMethod.POST)
        public String update(@ModelAttribute("hurtownia") Hurtownia hurtownia) {
            try {
                dao.updateHurtownie(hurtownia);
            }
            catch (Exception e) {
                return "redirect:/tabela_hurtownie";
            }
            return "redirect:/tabela_hurtownie";
        }

        @RequestMapping("/deleteHurtownie/{nrHurtowni}")
        public String delete(@PathVariable(name = "nrHurtowni") int nrHurtowni, @ModelAttribute("hurtownia") Hurtownia hurtownia) {
            dao.deleteHurtownie(nrHurtowni);

            return "redirect:/tabela_hurtownie";
        }

        /////////////////////////////////////////
        @RequestMapping("/tabela_produkty")
        public String viewAdminProdukty(Model model) {
            /* Import java.util.List */
            List<Produkt> listProdukt = daoP.list();
            model.addAttribute("listProdukt", listProdukt);
            return "admin/tabela_produkty";
        }

        @RequestMapping("/newProdukty")
        public String showNewFormProdukty(Model model){
            Produkt produkt = new Produkt();
            model.addAttribute("produkt", produkt);
            return "admin/new_form_produkty";
        }

        @RequestMapping(value = "/saveProdukty", method = RequestMethod.POST)
        public String save(@ModelAttribute("produkt") Produkt produkt) {
            try {
                daoP.saveProdukty(produkt);
            }
            catch (Exception e) {
                return "redirect:/tabela_produkty";
            }
            return "redirect:/tabela_produkty";
        }

        @RequestMapping("/editProdukty/{nrProduktu}")
        public ModelAndView showEditFormProdukty(@PathVariable(name = "nrProduktu") int nrProduktu) {
            ModelAndView mav = new ModelAndView("admin/edit_form_produkty");
            Produkt produkt = daoP.getProdukty(nrProduktu);
            mav.addObject("produkt", produkt);

            return mav;
        }

        @RequestMapping(value = "/updateProdukty", method = RequestMethod.POST)
        public String update(@ModelAttribute("produkt") Produkt produkt) {
            try {
                daoP.updateProdukty(produkt);
            }
            catch (Exception e) {
                return "redirect:/tabela_produkty";
            }
            return "redirect:/tabela_produkty";
        }

        @RequestMapping("/deleteProdukty/{nrProduktu}")
        public String delete(@PathVariable(name = "nrProduktu") int nrProduktu, @ModelAttribute("produkt") Produkt produkt) {
            daoP.deleteProdukty(nrProduktu);

            return "redirect:/tabela_produkty";
        }
        ////////////////////////////////////////

        @RequestMapping("/tabela_klienci")
        public String viewAdminKlienci(Model model) {
            /* Import java.util.List */
            List<Klient> listKlient = daoK.list();
            model.addAttribute("listKlient", listKlient);
            return "admin/tabela_klienci";
        }

        @RequestMapping("/newKlienci")
        public String showNewFormKlienci(Model model){
            Klient klient = new Klient();
            model.addAttribute("klient", klient);
            return "admin/new_form_klienci";
        }

        @RequestMapping(value = "/saveKlienci", method = RequestMethod.POST)
        public String save(@ModelAttribute("klient") Klient klient) {
            try {
                daoK.saveKlienci(klient);
            }
            catch (Exception e) {
                return "redirect:/tabela_klienci";
            }
            return "redirect:/tabela_klienci";
        }

        @RequestMapping("/editKlienci/{nrKlienta}")
        public ModelAndView showEditFormKlienci(@PathVariable(name = "nrKlienta") int nrKlienta) {
            ModelAndView mav = new ModelAndView("admin/edit_form_klienci");
            Klient klient = daoK.getKlienci(nrKlienta);
            mav.addObject("klient", klient);

            return mav;
        }


        @RequestMapping(value = "/main", method = RequestMethod.POST)
        public String update(@ModelAttribute("klient") Klient klient, HttpServletRequest request) {
            try {
                daoK.updateKlienci(klient);
            }
            catch (Exception e) {
                if (request.isUserInRole("ADMIN")) {
                    return "redirect:/tabela_klienci";
                } else if (request.isUserInRole("USER")) {
                    return "redirect:/main_user";
                }else {
                    return "redirect:/index";
                }
            }
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/tabela_klienci";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }else {
                return "redirect:/index";
            }

        }

        @RequestMapping("/deleteKlienci/{nrKlienta}")
        public String delete(@PathVariable(name = "nrKlienta") int nrKlienta, @ModelAttribute("klient") Klient klient) {
            daoK.deleteKlienci(nrKlienta);

            return "redirect:/tabela_klienci";
        }


        @RequestMapping(value={"/", "/index"})
        public String mainPage(Model model) {
            /* Import java.util.List */
            List<Hurtownia> listHurtownia = dao.list();
            model.addAttribute("listHurtownia", listHurtownia);
            return "index";
        }

        @RequestMapping("/InformacjeOProdukcie/{nrProduktu}")
        public ModelAndView showProducts(@PathVariable(name = "nrProduktu") int nrProduktu) {
            ModelAndView mav = new ModelAndView("informacjeOProdukcie");
            List<Produkt> produkt = daoP.listWithProdukt(nrProduktu);
            mav.addObject("produkt", produkt);

            return mav;
        }
        @RequestMapping("/produkty_oferta")
        public String viewOfertaProdukty(Model model) {
            /* Import java.util.List */
            List<Produkt> listProdukt = daoP.list();
            model.addAttribute("listProdukt", listProdukt);
            return "produkty_oferta";
        }

        @RequestMapping("/moje_dane/{login}")
        public ModelAndView viewMojeDane(@PathVariable(name = "login") String login){
            ModelAndView mav = new ModelAndView("user/dane_uzytkownika");
            List<Klient> klient = daoK.listWithLogin(login);
            mav.addObject("klient", klient);

            return mav;
        }

        @RequestMapping("/adresy/{nrAdresu}")
        public ModelAndView viewAdresyHurtowni(@PathVariable(name = "nrAdresu") int nrAdresu){
            ModelAndView mav = new ModelAndView("adres_hurtowni");
            List<Adres> adres = daoA.listWithNrAdresu(nrAdresu);
            mav.addObject("adres", adres);

            return mav;
        }

    }


    @RequestMapping(value={"/tebela_hurtownie"})
    public String showAdminPage(Model model) {
        return "tebela_hurtownie";
    }

    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}