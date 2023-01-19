package com.codeup.blogapp.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String PlayGame(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String guess(@PathVariable int guess, Model model){
        int random = (int)(Math.random() * 6 + 1);
        String guessResult = "";
        if(random == guess){
            guessResult += "Guess correct!";
        } else {
            guessResult += "Not quite,  try again!";
        }
        String guessDisplay = "You guessed : " + guess;
        String outcome = "The dice roll is : " + random;

        model.addAttribute("guess",guessDisplay);
        model.addAttribute("outcome", outcome);
        model.addAttribute("guessResult", guessResult);
        return "roll-dice";


    }

}
