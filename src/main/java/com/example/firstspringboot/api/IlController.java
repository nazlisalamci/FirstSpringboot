package com.example.firstspringboot.api;


import com.example.firstspringboot.model.Il;
import com.example.firstspringboot.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/il")
@AllArgsConstructor
public class IlController{

    private final IlService ilService;

    @GetMapping
    public ResponseEntity<List<Il>> getIller(){

        return new ResponseEntity<>(ilService.getIller(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
        Il result=getIlById(id);
      return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping
    //string ,void ,il
    public ResponseEntity<Il> createIl(@RequestBody Il newIl){
        return new ResponseEntity<>(ilService.createIl(newIl),HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getIl(@PathVariable String id ,@RequestBody Il newil){

        Il oldId=getIlById(id);
        oldId.setName(newil.getName());
        oldId.setCreateDate(new Date());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        ilService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    private Il getIlById(String id){
        return  ilService.getIlById(id);
    }
}
