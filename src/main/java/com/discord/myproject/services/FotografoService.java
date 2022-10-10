package com.discord.myproject.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.discord.myproject.models.Fotografo;
import com.discord.myproject.repositories.FotografoRepository;

@Service
    public class FotografoService {
@Autowired
    FotografoRepository repository;

    public List<Fotografo> getAll() 
    {
        return repository.findAll();
    }

    public Fotografo store(Fotografo newFotografo) 
    {
        return repository.save(newFotografo);
    }

    public Map<String,String> delete(Long id) 
    {
        Map<String,String> message = new HashMap<>();
        if (repository.findById(id).isPresent()) 
        {
            repository.deleteById(id);
            message.put ("message", "ok");
            return message;
        }
        message.put("message", "error");
        return message;
    }

public Fotografo update(Long id, Fotografo newDataFotografo)
    {
        return repository.findById(id)
        .map((fotografo)->{
            fotografo.setName(newDataFotografo.getName());
            fotografo.setEmail(newDataFotografo.getEmail());
            return repository.save(fotografo);
        })
        .orElseGet(()->{
            return repository.save(newDataFotografo);
        });
    }
}
