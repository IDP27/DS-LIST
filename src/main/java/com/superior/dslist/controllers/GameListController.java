package com.superior.dslist.controllers;


import com.superior.dslist.Dto.GameListDTO;
import com.superior.dslist.services.GameListService;
import com.superior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List <GameListDTO>findAll(){
        List <GameListDTO> result = gameListService.findAll();
        return result;

    }


}
