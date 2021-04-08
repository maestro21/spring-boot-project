package ru.geekbrains.boot.controllers;

import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorHandlingController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Throwable t = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        model.addAttribute("message", t.getMessage());
        model.addAttribute("class", t.getClass());
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}