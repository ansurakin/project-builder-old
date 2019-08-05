package com.alex.development.tools.project.builder.common.crud;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

public class BaseController <T extends Object, ID extends Serializable>{
    
    @Autowired(required = true)
    private BaseService<T, ID> service;
    
    @RequestMapping(value = "/list", method = GET)
    public List<T> list() {
        return this.service.findAll();
    }
    
    @RequestMapping(value = "/get", params = {"id"}, method = GET)
    public T get(@RequestParam ID id) {
        return (T) this.service.findOne(id);
    }
    
    @RequestMapping(value = "/save", method = POST)
    public T save(@RequestBody T input) {
        return (T) this.service.save(input);
    }
    
    @RequestMapping(value = "/delete", params = {"id"}, method = DELETE)
    public ResponseEntity<ID> delete(@RequestParam ID id) {
        ID result = this.service.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
//    @RequestMapping(value = "/delete", params = {"id"}, method = DELETE)
//    public ID delete(@RequestParam ID id) {
//        return (ID) this.service.delete(id);
//    }
    
}
