package com.discord.myproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.discord.myproject.models.Fotografo;

@Repository
public interface FotografoRepository  extends JpaRepository<Fotografo,Long>{
    
}
