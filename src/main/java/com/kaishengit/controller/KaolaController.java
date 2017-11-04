package com.kaishengit.controller;


import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.service.KaolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by hoyt on 2017/11/4.
 */

@Controller
@RequestMapping("/kaola")
public class KaolaController {

    @Autowired
    private KaolaService kaolaService;

    @GetMapping
    public String findByPageNo(@RequestParam(name = "p",defaultValue = "1",required = false) Integer pageNo,
                               Model model) {

        PageInfo<Kaola> pageInfo = kaolaService.findByPageNo(pageNo);
        model.addAttribute("pageInfo",pageInfo);
        return "kaola/list";
    }

    @GetMapping("new")
    public String save(Model model){
        model.addAttribute("typeList",kaolaService.findAllType());
        return "kaola/new";
    }

    @PostMapping("new")
    public String save(Kaola kaola, RedirectAttributes redirectAttributes) {
        kaolaService.save(kaola);
        redirectAttributes.addFlashAttribute("message","保存成功");
        return "redirect:/kaola";
    }

    @GetMapping("/{id:\\d+}")
    public String showKaola(@PathVariable Integer id, Model model) {
        Kaola kaola = kaolaService.findById(id);
        model.addAttribute("kaola",kaola);
        return "kaola/show";
    }

    @GetMapping("/{id:\\d+}/edit")
    public String editProduct(@PathVariable Integer id,Model model) {
        model.addAttribute("typeList",kaolaService.findAllType());
        model.addAttribute("kaola",kaolaService.findById(id));
        return "kaola/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editProduct(Kaola kaola,RedirectAttributes redirectAttributes) {
        kaolaService.edit(kaola);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/kaola/"+kaola.getId();
    }

    @GetMapping("/{id:\\d+}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
        kaolaService.delete(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/kaola";
    }

}
