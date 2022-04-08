/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unu.jogja.projectktp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller
public class DataController {
    
    DataJpaController datactrl = new DataJpaController();
    List<Data> newdata = new ArrayList<>();
            
    @RequestMapping("/main")
    public String getMain() {
        return "menu";
    }
    
    @RequestMapping("/data")
    @ResponseBody
    public String getDataKTP(Model model){
        int record = datactrl.getDataCount();
        try {
            newdata = datactrl.findDataEntities(0, record);}
        catch (Exception e){}
        model.addAttribute("goData", newdata);
        
        return "database";
    }
    
}
