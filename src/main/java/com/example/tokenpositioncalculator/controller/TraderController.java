package com.example.tokenpositioncalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trader")
public class TraderController {
    /*
    private final TraderService traderService;
    private final WalletService walletService;

    public TraderController(TraderService traderService, WalletService walletService) {
        this.traderService = traderService;
        this.walletService = walletService;
    }

    @GetMapping("/create")
    public String traderCreate(Model model){

       model.addAttribute("trader", new TraderDTO());
       model.addAttribute("traders", traderService.listAllTraders());
      //  model.addAttribute("traders", traders);

        return "/trader/create";
    }
    @PostMapping("/create")
    public String insertTrader(@Valid @ModelAttribute("trader") TraderDTO trader, BindingResult bindingResult, Model model) {

       /* if (bindingResult.hasErrors()) {
            model.addAttribute("traders", traderService.listAllTraders());
            return "/trader/create";
        }*/

        //traderService.save(trader);
        //return "redirect:/trader/create";
    //}

}
