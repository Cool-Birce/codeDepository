package com.gec.controller;

import com.gec.pojo.Product;
import com.gec.pojo.UserAndProduct;
import com.gec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author Brice
 * @title: ProductController
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/119:49
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    private ModelAndView mav;
    @Autowired
    private ProductService productService;

    @RequestMapping("/itemEdit")
    public String updateView(Model m, Integer id) {
        Product p = productService.findById(id);
        m.addAttribute("item", p);
        return "productItem";
    }

    @RequestMapping("/update")
    public ModelAndView update(Product product, MultipartFile pictureFile, HttpServletRequest request) {

        String filename=null;
        if (!pictureFile.isEmpty()) {
            try {
                File file = new File(request.getServletContext().getRealPath("/pic"));
                System.out.println(file);
                if (file.exists()) {
                    file.mkdirs();
                }
                filename = pictureFile.getOriginalFilename();
                filename = UUID.randomUUID().toString().replace("-", "") + filename.substring(filename.lastIndexOf("."));
                pictureFile.transferTo(new File(file + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mav = new ModelAndView();
        product.setPic(filename);
        int i = productService.update(product);
        List<Product> list = productService.findAll();
        System.out.println(list);
        mav.addObject("productList", list);
        mav.setViewName("productList");
        return mav;
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        mav = new ModelAndView();
        List<Product> list = productService.findAll();
        mav.addObject("productList", list);
        mav.setViewName("productList");
        return mav;
    }

    @RequestMapping("/delAll")
    public ModelAndView delAll(Integer[] ids) {
        mav = new ModelAndView();
        for (Integer id : ids) {
            productService.del(id);
        }
        findAll();
        return mav;
    }

    @RequestMapping("/updateAll")
    public ModelAndView updateAll(UserAndProduct uap) {
        mav = new ModelAndView();
        List<Product> productList = uap.getProductList();
        for (Product product : productList) {
            int update = productService.update(product);
        }

        return findAll();
    }

    @RequestMapping("/selectCondition")
    @ResponseBody
    public List<Product> selectCondition(@RequestBody UserAndProduct uap) {
        Product product = uap.getProduct();
        List<Product> productList = productService.selectCondition(product);
        return productList;
    }

}
