package com.discord.myproject.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.discord.myproject.models.Fotografo;
import com.discord.myproject.services.FotografoService;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/")
    public class FotografoController {
    @Autowired
    FotografoService fotografoService;

@GetMapping(value = "/fotografos")
    public List<Fotografo> getAll() 
    {
        return fotografoService.getAll();
    }

@PostMapping(value = "/fotografos")
    public Fotografo store(@RequestBody Fotografo newFotografo) 
    {
        Fotografo fotografo = fotografoService.store(newFotografo);
        return fotografo;
    }

@DeleteMapping(path = "/fotografos/{id}")
    public Map<String, String> deleteFotografoMap(@PathVariable Long id) 
    {
        Map<String, String> message = fotografoService.delete(id);
        return message;
    }

    @PutMapping(path = "/fotografos/{id}")
    public Fotografo updateFotografo(@PathVariable Long id, @RequestBody Fotografo fotografo)
    {
        return fotografoService.update(id, fotografo);
    }    
}
