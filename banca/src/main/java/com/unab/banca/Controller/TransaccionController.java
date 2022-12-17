package com.unab.banca.Controller;
import com.unab.banca.Models.Transaccion;
//import com.unab.banca.Security.Hash;
import com.unab.banca.Dao.TransaccionDao;
import com.unab.banca.Service.TransaccionService;
import java.util.List;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/transaccion")
public class TransaccionController {
    @Autowired
    private TransaccionDao transaccionDao; 
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping(value="/")
    public ResponseEntity<Transaccion> agregar(@RequestBody Transaccion transaccion){        
        Transaccion obj = transaccionService.save(transaccion);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }

    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Transaccion> eliminar(@PathVariable String id){ 
        Transaccion obj = transaccionService.findById(id); 
        if(obj!=null) 
            transaccionService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }

    @PutMapping(value="/") 
    public ResponseEntity<Transaccion> editar(@RequestBody Transaccion transaccion){ 
        Transaccion obj = transaccionService.findById(transaccion.getId_transaccion()); 
        if(obj!=null) { 
            obj.setFecha_transaccion(transaccion.getFecha_transaccion());
            obj.setValor_transaccion(transaccion.getValor_transaccion());
            obj.setTipo_transaccion(transaccion.getTipo_transaccion());
            obj.setId_cuenta(transaccion.getId_cuenta());
            transaccionService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }

    @GetMapping("/list") 
    public List<Transaccion> consultarTodo(){
        return transaccionService.findAll(); 
    }
    @GetMapping("/list/{id}") 
    public Transaccion consultaPorId(@PathVariable String id){ 
        return transaccionService.findById(id); 
    }
}