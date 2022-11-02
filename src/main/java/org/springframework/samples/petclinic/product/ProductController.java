package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("/product")
public class ProductController {
private final ProductService productService;
private static final String VIEW_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProduct";
private static final String VIEW_LIST_PRODUCT = "products/productList";

@Autowired
public ProductController(ProductService productService){
    this.productService = productService;
}

@GetMapping("")
public ModelAndView listProduct(){
    ModelAndView mav = new ModelAndView(VIEW_LIST_PRODUCT);
    mav.addObject("products", productService.getAllProducts());
    return mav;
}

@GetMapping("/create")
public ModelAndView createProduct(){
    ModelAndView mav = new ModelAndView(VIEW_CREATE_OR_UPDATE_FORM);
    mav.addObject("product", new Product());
    mav.addObject("types", productService.findAllProductTypes());
    return mav;
}

@PostMapping("/create")
public ModelAndView postProduct(@Valid Product product, BindingResult br){
    ModelAndView mav;
    if(br.hasErrors()){
        mav = new ModelAndView(VIEW_CREATE_OR_UPDATE_FORM);
        mav.addObject("product",product);
       
    }else{
        this.productService.save(product);
        mav = new ModelAndView("welcome");
    }
    return mav;
}
}
