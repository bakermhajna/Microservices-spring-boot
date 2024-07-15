package com.udemycourse.cards.Controller;


import com.udemycourse.cards.Constans.CardConstans;
import com.udemycourse.cards.DTO.CardDTO;
import com.udemycourse.cards.DTO.ResponseDTO;
import com.udemycourse.cards.Services.ICardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cards",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CardController {

    @Autowired(required=true)
    private ICardService cardService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                         @RequestBody
                                                         String mobileNumber){
        System.out.println(mobileNumber);
        cardService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(CardConstans.STATUS_201,CardConstans.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardDTO> fetchCard(@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                 @RequestParam
                                                 String mobileNumber){
        CardDTO cardDTO=cardService.fetchCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cardDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CardDTO cardDto) {
        boolean isUpdated = cardService.updateCard(cardDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(CardConstans.STATUS_200, CardConstans.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(CardConstans.STATUS_417, CardConstans.MESSAGE_417_UPDATE));
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam
                                                            @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                            String mobileNumber) {
        boolean isDeleted = cardService.deleteCard(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(CardConstans.STATUS_200, CardConstans.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(CardConstans.STATUS_417, CardConstans.MESSAGE_417_DELETE));
        }
    }
}
