package app.novacode.myservice.src.web;



import app.novacode.myservice.src.domain.entity.BusinessDomain;
import app.novacode.myservice.src.domain.service.BusinessService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;


    @GetMapping("/all")
   public List<BusinessDomain> getAll(){
        return businessService.getAll();
    }

    @GetMapping("/{id}")
   public Optional<BusinessDomain> getBusinessById(@PathVariable("id") String idBusiness){
        return businessService.findByBusinessId(idBusiness);
    }


    @GetMapping("/area/{a}")
   public Optional<List<BusinessDomain>> getBusinessByArea(@PathVariable("a")String businessArea){
        return businessService.findByBusinessArea(businessArea);
    }


    @GetMapping("/name/{bName}")
   public Optional<List<BusinessDomain>> getBusinessByName(@PathVariable("bName")String bName){
        return businessService.findByName(bName);
    }


    @GetMapping("/seller/{sellerId}")
    Optional<BusinessDomain> getBusinessBySellerId(@PathVariable("sellerId") String sellerId){

        return businessService.findByUserId(sellerId);
    }


    @PostMapping
    public BusinessDomain saveBusiness(@RequestBody BusinessDomain businessDomain) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);

        int codeUser = Integer.parseInt(businessDomain.getSellerId());



        if (codeUser < 999999) businessDomain.setBusinessId("BU00" + codeUser);
        if (codeUser > 999999 && codeUser < 9999999) businessDomain.setBusinessId("BU0" + codeUser);
        if (codeUser > 999999 && codeUser < 99999999) businessDomain.setBusinessId("BU" + codeUser);


        try{

            byte[] bytes = businessDomain.getImageByte();

           // Path path = Paths.get("../var/www/html/" + businessDomain.getBusinessId() + ".png");
            //String imagePath = s;
            FileOutputStream output = new FileOutputStream(s + businessDomain.getBusinessId() + ".png");
            output.write(bytes);

            businessDomain.setImageUrl("http://172.245.226.231:8080/myservice/api/v1" + s + businessDomain.getBusinessId() + ".png");

            System.out.println(businessDomain.getImageUrl());


        }catch (Exception e){
            e.printStackTrace();


        }








        return businessService.saveBusiness(businessDomain);
    }



    @PostMapping("/uploadFile")
    public String saveImage(@RequestParam("file")MultipartFile multipartFile, ModelMap modelMap) throws IOException {

        //donde guardarás tu archivo, asegurate de que tengas permisos de escritura
        String pathFinal = "/Volumes/DataNova/Privado/uploaded_files_spring";
        //validación básica
        if(!multipartFile.isEmpty()){
            //creo un nuevo archivo
            File file = new File(pathFinal);
            FileUtils.touch(file);
            //transfiero el archivo multipart al disco.
            multipartFile.transferTo(file);
        }
        return "fileUploadView";

    }


    @DeleteMapping("/{id}")
    public boolean deleteBusiness(@PathVariable("id") String businessId){



        return businessService.deleteBusiness(businessId);
    }







}
