/*
 * Class name :  HaircutRESTController
 *
 * @author Dmitriy Futsur
 *
 * @version 1.0.0 15-Aug-2020
 *
 * Copyright (c) Dmitriy Futsur
 *
 * Description:
 */

package fuda.com.beauty_bar.controller.rest;

import fuda.com.beauty_bar.model.Haircut;
import fuda.com.beauty_bar.service.haircut.impls.HaircutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/haircut")
@RestController
public class HaircutRESTController {

    @Autowired
    HaircutServiceImpl haircutService;

    @RequestMapping("")
    String getIndex() {
        return "<h1>Index Web Controller</h1>";
    }

    @GetMapping("/hello")
    String getHello() {
        return "<h1>Hello from Haircut Controller</h1>";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @CrossOrigin
    List<Haircut> getHaircutsList() {
        return haircutService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Haircut createHaircut(@RequestBody Haircut haircut){
        haircut.setCreatedAt(LocalDateTime.now());
        haircut.setUpdatedAt(LocalDateTime.now());
        return haircutService.create(haircut);
    }

    @CrossOrigin
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Haircut getHaircut(@PathVariable("id") String id) {
        return haircutService.get(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Haircut updateHaircut(@RequestBody Haircut haircut){
        return haircutService.update(haircut);
    }

    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    Haircut deleteHaircut(@PathVariable("id") String id){
        return haircutService.delete(id);
    }
}
