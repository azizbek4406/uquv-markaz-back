package net.idrok.oquvmarkaz.controller;


import net.idrok.oquvmarkaz.entity.Fayl;
import net.idrok.oquvmarkaz.service.FaylService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/api/fayl")
@CrossOrigin(value = "*", maxAge = 3600)
public class FaylController {
    private final FaylService faylService;

    private final String ROOT_FOLDER = "Image";


    public FaylController(FaylService faylService) {
        this.faylService = faylService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Fayl> upload(@RequestParam("fayl") MultipartFile file){
        Fayl fayl = new Fayl();
        fayl.setNom(file.getOriginalFilename());
        fayl = faylService.create(fayl);
        try {
            // Root papkani yo'q bo'lsa yaratib olish
            File f = new File(ROOT_FOLDER);
            if(!f.exists()) f.mkdirs();

            // Faylni saqlash
            f = new File(ROOT_FOLDER + File.separator + fayl.getId() + getKengaytma(fayl.getNom()));
            f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            faylService.deleteById(fayl.getId());
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(fayl);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id){
        Fayl f = faylService.getById(id).orElseThrow(()->new RuntimeException("not found"));

        File file = new File(ROOT_FOLDER + File.separator + f.getId() + getKengaytma(f.getNom()));
        if(file.exists()){
            try {
                MediaType  mediaType = MediaTypeFactory.getMediaType(f.getNom()).orElse(MediaType.APPLICATION_OCTET_STREAM);

                ContentDisposition cd = ContentDisposition.
                        inline()
                        .filename(f.getNom())
                        .build();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(mediaType);
                headers.setContentDisposition(cd);

                return new ResponseEntity<>(new InputStreamResource(new FileInputStream(file)), headers, HttpStatus.OK);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("file not exists");

    }



    private String getKengaytma(String faylNom){
        if(faylNom != null && !faylNom.isEmpty()){
            return faylNom.substring(faylNom.lastIndexOf("."));
        }
        return "";
    }

}