package com.anthropocene.changement.controller;

import com.anthropocene.changement.model.User;
import com.anthropocene.changement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LoginController {
    private UserService utilisateurService;

    @Autowired
    public void setUtilisateurService(UserService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @RequestMapping(value = "/formInsert")
    public String FormLogin(Map<String, Object> modelMap)
    {
        modelMap.put("Utilisateur",new User());
        return "FormLogin";
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String TraitLogin(@ModelAttribute("User") @Validated User utilisateur,
                             BindingResult bindingResult, Model model, HttpServletRequest request)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("Utilisateur",new User());
            return "FormLogin";
        }
        else
        {
            User util=utilisateurService.getUtilisateur(request.getParameter("Email"),request.getParameter("MotDePasse"));

            if(util.getId()==0)
            {
                model.addAttribute("erreur","Verifier votre identifiant et votre mot de passe");
                model.addAttribute("Utilisateur",new User());
                return "FormLogin";
            }
            else
            {
                HttpSession sess=request.getSession();
                sess.setAttribute("IdUtilisateur",util.getId());
                return "Accueil";
            }
        }
    }
}
