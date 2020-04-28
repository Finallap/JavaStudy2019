package com.controller;

import com.bean.FileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/**
 * @description: FileUploadController
 * @date: 2020/4/27 17:34
 * @author: Finallap
 * @version: 1.0
 */
@Controller
public class FileUploadController {
    @Autowired
    ServletContext context;

    @RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
    public ModelAndView fileUploadPage() {
        FileModel file = new FileModel();
        return new ModelAndView("jsp/fileUpload", "command", file);
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException {
        if (result.hasErrors()) {
            System.out.println("validation errors");
            return "jsp/fileUpload";
        } else {
            System.out.println("Fetching file");
            String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;

            FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath + file.getFile().getOriginalFilename()));
            String fileName = file.getFile().getOriginalFilename();
            model.addAttribute("fileName", fileName);
            return "jsp/fileUploadSuccess";
        }
    }
}
