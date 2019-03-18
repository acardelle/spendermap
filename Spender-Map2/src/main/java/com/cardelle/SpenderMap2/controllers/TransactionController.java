package com.cardelle.SpenderMap2.controllers;

import com.cardelle.SpenderMap2.models.Transaction;
import com.cardelle.SpenderMap2.models.CheeseType;
import com.cardelle.SpenderMap2.models.data.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by LaunchCode - Enhanced by Cardelle
 */
@Controller
@RequestMapping("transaction")
public class TransactionController {
//test
    @Autowired
    private TransactionDao transactionDao;

    // Request path: /transaction
    @RequestMapping(value = "")
    public String index(Model model) {
         model.addAttribute("transactions", transactionDao.findAll());
         model.addAttribute("title", "My Transactions");

        return "transaction/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTransactionForm(Model model) {
        model.addAttribute("title", "Add Transaction");
        model.addAttribute(new Transaction());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "transaction/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTransactionForm(@ModelAttribute  @Valid Transaction newTransaction,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Transaction");
            return "transaction/add";
        }

        transactionDao.save(newTransaction);
        return "transaction/index";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", transactionDao.findAll());
        model.addAttribute("title", "Remove Transaction");
        return "transaction/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
         //   transactionDao.delete(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "addCSV", method = RequestMethod.POST)
    public String processAddTransactionCSV(@ModelAttribute  @Valid Transaction newTransaction,
                                            Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Transaction");
            return "transaction/add";
        }

        transactionDao.save(newTransaction);
        return "transaction/index";
    }

}
