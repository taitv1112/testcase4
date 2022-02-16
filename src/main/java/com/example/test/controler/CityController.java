package com.example.test.controler;

import com.example.test.model.Nation;
import com.example.test.model.City;
import com.example.test.service.NationService;
import com.example.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CityController {
    @Autowired
    CityService cityService;
    @Autowired
    NationService nationService;

    @ModelAttribute("city")
    public City getUsers(){
        return  new City();
    }

    @GetMapping("/city")
    public ModelAndView showAll(@RequestParam (defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("cities", cityService.findAll(PageRequest.of(page,2)));
        return modelAndView;
    }
    @ModelAttribute("nation")
        public List<Nation> showRole(){
            return nationService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("createCity");
        return modelAndView;
    }

    @PostMapping("create")
    public Object add(@Valid @ModelAttribute(value = "users") City users, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("createCity");
            return modelAndView;
        }
        cityService.save(users);
        return "redirect:/city";
    }

    @GetMapping("edit")
    public ModelAndView edit(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("editCity");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }
    @GetMapping("showDeatail")
    public ModelAndView showDetail(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("showDetail");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("edit")
    public String editUser(@Valid @ModelAttribute(value = "city") City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "redirect:/editCity";
        }

        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("/delete")
    public ModelAndView deleteForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("deleteCity");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        cityService.delete(id);
        return "redirect:/City";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam (value = "search") String search,@RequestParam (defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("cities", cityService.findUsersByName(search,PageRequest.of(page,2)));
        return modelAndView;
    }



}
