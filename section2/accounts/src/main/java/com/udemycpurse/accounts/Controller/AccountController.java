package com.udemycpurse.accounts.Controller;

import com.udemycpurse.accounts.Constants.AccountsConstants;
import com.udemycpurse.accounts.DTO.CustomerDTO;
import com.udemycpurse.accounts.DTO.ResponseDTO;
import com.udemycpurse.accounts.Service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/accounts",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO coustomerdto){

        System.out.println(coustomerdto);
        accountService.createAccount(coustomerdto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));


    }


}
